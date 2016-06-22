import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;

import java.io.*;


public class JXLTestMain {

	private final static String filename = "d://jxltest.xls";
	private final static String[] headersOneCol = {"币种", "日期", "明细标志", "顺序号", "付款账号开户行", "付款账号/卡号", "付款账号名称/卡名称", "收款账号开户行", "收款账号省份", "收款账号地市", "收款账号地区码", "收款账号", "收款账号名称", "金额", "汇款用途", "备注信息", "汇款方式", "收款账户短信通知手机号码", "自定义序号"};

	private final static int rows = 65535;

	public static void main (String[] args) {
		writeExcel ();
		//readExcel();
	}

	public static void writeExcel () {
		try {
			Thread.sleep (1000 * 20);
		} catch (InterruptedException e1) {
			e1.printStackTrace ();
		}
		try {
		/*	response.setContentType("application/x-download");
			BufferedOutputStream bos = null;
			OutputStream os = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String formatDate = dateFormat.format(new Date ());
			try {
				response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(formatDate + "站场提现.xls", "UTF-8"));
				os = response.getOutputStream();
				bos = new BufferedOutputStream(os);
				WritableWorkbook workbook = Workbook.createWorkbook(bos);*/
			WritableWorkbook workbook = Workbook.createWorkbook (new File (filename));

			WritableSheet sheet = workbook.createSheet ("jxl测试", 0);

			for (int i = 0; i < headersOneCol.length; i++) {
				Label label = new Label (i, 0, headersOneCol[i]);
				sheet.addCell (label);
			}

			int c = 2;
			for (int i = 0; i < 100; i++) {
				sheet.addCell (new Number (0, c, i));
				sheet.addCell (new Label (1, c, "gggg" + i));
				sheet.addCell (new Number (2, c, i));
				sheet.addCell (new Number (3, c, i));
				sheet.addCell (new Label (4, c, "ggaaaaa" + i));
				c++;
			}

			workbook.write ();
			workbook.close ();
		} catch (IOException e) {
			e.printStackTrace ();
		} catch (RowsExceededException e) {
			e.printStackTrace ();
		} catch (WriteException e) {
			e.printStackTrace ();
		}

	}

	public static void readExcel () {
		try {
			Thread.sleep (1000 * 20);
		} catch (InterruptedException e1) {
			e1.printStackTrace ();
		}
		try {
			long s1 = System.nanoTime ();
			Workbook workbook = Workbook.getWorkbook (new File (filename));
			Sheet sheet = workbook.getSheet (0);
			System.out.println (sheet.getName ());
			for (int i = 0; i < sheet.getRows (); i++) {
				Cell[] cells = sheet.getRow (i);
				for (Cell cell : cells) {
					if (cell.getType () == CellType.NUMBER) {
						System.out.print (((NumberCell) cell).getValue () + "  ");
					} else if (cell.getType () == CellType.LABEL) {
						System.out.print (cell.getContents () + "  ");
					}
				}
				System.out.println ();
			}
			workbook.close ();
			long s2 = System.nanoTime ();
			System.out.println ("jxl read " + rows + " rows from excel:" + (s2 - s1));
		} catch (BiffException e) {
			e.printStackTrace ();
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}

}
