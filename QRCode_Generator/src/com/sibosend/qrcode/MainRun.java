package com.sibosend.qrcode;

import java.io.File;

public class MainRun{

	private static String content;
	private static String imgPath;
	private static String logoPath;
	// 二维码内容形状
	private static int conType;
	// 码眼类型
	private static int qrType;
	// 二维码内容去颜色
	private static int colorArray[];
	// 二维码码眼外框颜色
	private static int colorOut[];
	// 二维码码眼内框框颜色
	private static int colorIn[];

	public static void main(String[] args) {

		content = args[0];
		imgPath = args[1];
		logoPath = args[2];
		conType = Integer.parseInt(args[3]);
		qrType = Integer.parseInt(args[4]);
		colorArray = colorChange(args[5]);
		colorOut = colorChange(args[6]);
		colorIn = colorChange(args[7]);

		QRCodeCreate codeGreate = new QRCodeCreate();

		try {

			File file = new File(imgPath);
			if (!file.exists()) {
				file.mkdirs();
			}
			imgPath += "/qrCode.png";

			// 生成二维码
			codeGreate.qrCodeEncode(content, imgPath, logoPath, conType, qrType, colorArray[0], colorArray[1],
					colorArray[2], colorOut[0], colorOut[1], colorOut[2], colorIn[0], colorIn[1], colorIn[2]);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static int[] colorChange(String color) {
		String str2 = color.substring(0, 2);
		String str3 = color.substring(2, 4);
		String str4 = color.substring(4);
		int red = Integer.parseInt(str2, 16);
		int green = Integer.parseInt(str3, 16);
		int blue = Integer.parseInt(str4, 16);

		int[] colorArray = new int[] { red, green, blue };

		return colorArray;
	}

}
