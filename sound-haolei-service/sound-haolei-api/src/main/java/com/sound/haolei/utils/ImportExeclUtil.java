package com.sound.haolei.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ImportExeclUtil {
	private Sheet sheet; // 表格类实例
	LinkedList[] result; // 保存每个单元格的数据 ，使用的是一种链表数组的结构

	private static class ImportExeclUtilHandler {
		private static ImportExeclUtil instance = new ImportExeclUtil();
	}

	private ImportExeclUtil() {
	}

	public static ImportExeclUtil getInstance() {
		return ImportExeclUtilHandler.instance;
	}

	// 读取excel文件，创建表格实例
	private void loadExcel(String filePath) {
		FileInputStream inStream = null;
		try {
			inStream = new FileInputStream(new File(filePath));
			Workbook workBook = WorkbookFactory.create(inStream);

			sheet = workBook.getSheetAt(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 获取单元格的值
	private String getCellValue(Cell cell) {
		String cellValue = "";
		DataFormatter formatter = new DataFormatter();
		if (cell != null) {
			// 判断单元格数据的类型，不同类型调用不同的方法
			switch (cell.getCellType()) {
			// 数值类型
			case Cell.CELL_TYPE_NUMERIC:
				// 进一步判断 ，单元格格式是日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					cellValue = formatter.formatCellValue(cell);
				} else {
					// 数值
					double value = cell.getNumericCellValue();
					/*int intValue = (int) value;*/
					//cellValue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
					BigDecimal bd = new BigDecimal(value); 
					cellValue = bd.toString();
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			// 判断单元格是公式格式，需要做一种特殊处理来得到相应的值
			case Cell.CELL_TYPE_FORMULA: {
				try {
					cellValue = String.valueOf(cell.getNumericCellValue());
				} catch (IllegalStateException e) {
					cellValue = String.valueOf(cell.getRichStringCellValue());
				}

			}
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
			case Cell.CELL_TYPE_ERROR:
				cellValue = "";
				break;
			default:
				cellValue = cell.toString().trim();
				break;
			}
		}
		return cellValue.trim();
	}

	// 初始化表格中的每一行，并得到每一个单元格的值
	public synchronized void  init() {
		int rowNum = sheet.getLastRowNum() + 1;
		result = new LinkedList[rowNum];
		int cellNum = 0;
		if(rowNum > 0){
			//第一行为标题
			cellNum = sheet.getRow(0).getLastCellNum();
		}
		for (int i = 0; i < rowNum; i++) {
			Row row = sheet.getRow(i);
			if(null == row){
				continue;
			}
			// 每有新的一行，创建一个新的LinkedList对象
			LinkedList list = new LinkedList<>();
			Set<String> set = new HashSet<>();
			for (int j = 0; j < cellNum; j++) {
				Cell cell = row.getCell(j);
				// 获取单元格的值
				String str = getCellValue(cell);
				// 将得到的值放入链表中
				list.add(str);
				if(null != str && !"".equals(str.trim())){
					set.add(str);
				}
			}
			if(null != set && !set.isEmpty()){
				result[i] = list;
			}
		}
	}

	// 控制台打印保存的表格数据
	public void show() {
		for (int i = 0; i < result.length; i++) {
			if(null != result[i]){
				for (int j = 0; j < result[i].size(); j++) {
					System.out.print(result[i].get(j) + "\t");
				}
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @Title: getExcelData
	 * @Description: 获取excel数据
	 * @param path
	 *            设定文件 void 返回类型
	 * @throws @author
	 *             tianyunyun
	 * @date 2017年5月25日 上午10:01:39
	 */
	public LinkedList[] getExcelData(String path) {
		loadExcel(path);
		init();
		return result;
	}

	public static void main(String[] args) {
		ImportExeclUtil poi = new ImportExeclUtil();
		poi.loadExcel("D:\\8.22收快递.xlsx");
		poi.init();
		poi.show();
	}

	// 查快递
	public List<Map<String, Object>> getEmsSearchData() {
		List<Map<String, Object>> list = new ArrayList<>();
		getExcelData("D:\\8.22收快递.xlsx");
		if (null != result && result.length > 0) {
			for (int i = 1; i < result.length; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("express", "快递公司");
				map.put("bill", result[i].get(0));
				System.out.println();
			}
		}
		return list;
	}
	// 发快递
	// 上门回收
	// 水电缴费

}

class WDWUtil {
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
}
