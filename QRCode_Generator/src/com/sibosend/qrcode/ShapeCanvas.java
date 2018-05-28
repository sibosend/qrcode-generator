package com.sibosend.qrcode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ShapeCanvas {

	public static int canvas1(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {

		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 140, 140);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		gs.setColor(new Color(redout,greenout,blueout)); // 马眼
		gs.fillRect(10, 10, 120, 120);
		gs.setColor(Color.WHITE);
		gs.fillRect(28, 28, 84, 84);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillRect(47, 47, 45, 45);
		gs.dispose();
		bufferedImage.flush();

		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;

	}

	public static int canvas2(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {

		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(130, 130, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 130, 130);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		gs.setColor(new Color(redout,greenout,blueout)); // 马眼
		gs.fillRoundRect(10, 10, 115, 115, 50, 50);
		gs.setColor(Color.WHITE);
		gs.fillRoundRect(25, 25, 85, 85, 45, 45);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillRoundRect(45, 45, 45, 45, 30, 30);
		gs.dispose();
		bufferedImage.flush();

		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 2;
	}

	public static int canvas3(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {

		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 140, 140);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		gs.setColor(new Color(redout,greenout,blueout)); // 马眼
		gs.fillRect(10, 10, 115, 115);
		gs.setColor(Color.WHITE);
		gs.clearRect(60, 60, 115, 115);
		gs.setColor(new Color(redout,greenout,blueout));
		gs.fillArc(-20, -20, 145, 145, 0, -90);
		gs.setColor(Color.WHITE);
		gs.fillArc(-20, -20, 130, 130, 0, -90);
		gs.fillRect(28, 28, 82, 28);
		gs.fillRect(28, 28, 33, 82);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillArc(-15, -15, 113, 113, 0, -90);
		gs.dispose();
		bufferedImage.flush();
		
		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 3;

	}

	public static int canvas4(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {

		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(130, 130, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 130, 130);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		gs.setColor(new Color(redout,greenout,blueout)); //马眼
		gs.fillRoundRect(10, 10, 115, 115, 50, 50);
		gs.fillRect(10, 10, 20, 20);
		gs.fillRect(100, 100, 25, 25);
		gs.setColor(Color.WHITE);
		gs.fillRoundRect(25, 25, 85, 85, 50, 50);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillRoundRect(45, 45, 45, 45, 35, 35);
		gs.setColor(Color.WHITE);
		gs.fillRect(85, 85, 25, 25);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillRect(45, 45, 25, 25);
		gs.fillRect(65, 65, 25, 25);
		gs.dispose();
		bufferedImage.flush();

		// 生成二维码QRCode图片
		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 4;

	}

	public static int canvas5(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {

		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(130, 130, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 130, 130);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		gs.setColor(new Color(redout,greenout,blueout)); //马眼
		gs.fillRoundRect(10, 10, 115, 115, 50, 50);
		gs.fillRect(10, 10, 20, 20);
		gs.fillRect(100, 100, 25, 25);
		gs.setColor(Color.WHITE);
		gs.fillRoundRect(25, 25, 85, 85, 50, 50);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillRoundRect(45, 45, 45, 45, 35, 35);
		gs.setColor(Color.WHITE);
		gs.fillRect(85, 85, 25, 25);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillRect(45, 45, 25, 25);
		gs.fillRect(65, 65, 25, 25);
		gs.dispose();
		bufferedImage.flush();

		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);
	
			BufferedImage buffImage2 = ImageIO.read(new FileInputStream("./res/image.png"));
			ShapeCanvas.rotateImage(buffImage2, 180);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 5;

	}

	public static int canvas6(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {

		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(130, 130, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 130, 130);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		gs.setColor(new Color(redout,greenout,blueout)); // 红色马眼
		gs.fillRoundRect(10, 10, 115, 115, 50, 50);
		gs.fillRect(105, 10, 20, 20);
		gs.setColor(Color.WHITE);
		gs.fillRoundRect(25, 25, 85, 85, 50, 50);
		gs.fillRect(85, 25, 25, 25);
		gs.setColor(new Color(redin,greenin,bluein));
		gs.fillRoundRect(45, 45, 45, 45, 35, 35);
		gs.fillRect(65, 45, 25, 25);
		gs.dispose();
		bufferedImage.flush();

		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);

			BufferedImage buffImage2 = ImageIO.read(new FileInputStream("./res/image.png"));
			ShapeCanvas.rotateImage(buffImage2, 180);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 6;
	}

	public static int canvas7(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {
		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(130, 130, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 130, 130);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		gs.setPaint(new Color(redout, greenout, blueout));
		gs.setStroke(new BasicStroke(17));
		
		CubicCurve2D cubic1 = new CubicCurve2D.Double(13,13,23,63,3,63,13,112);
		CubicCurve2D cubic2 = new CubicCurve2D.Double(15,13,63,8,83,23,112,13);
		CubicCurve2D cubic3 = new CubicCurve2D.Double(112,13,123,43,103,63,112,111);
		CubicCurve2D cubic4 = new CubicCurve2D.Double(13,112,63,103,83,123,107,112);
		gs.draw(cubic1);
		gs.draw(cubic2);
		gs.draw(cubic3);
		gs.draw(cubic4);
		
		gs.setPaint(new Color(redin, greenin, bluein));
		gs.setStroke(new BasicStroke(5));
		CubicCurve2D cubic5 = new CubicCurve2D.Double(40,40,50,55,35,70,40,85);
		CubicCurve2D cubic6 = new CubicCurve2D.Double(40,40,55,35,70,45,85,40);
		CubicCurve2D cubic7 = new CubicCurve2D.Double(85,40,90,60,80,70,85,85);
		CubicCurve2D cubic8 = new CubicCurve2D.Double(40,85,55,80,70,90,85,85);
		gs.draw(cubic5);
		gs.draw(cubic6);
		gs.draw(cubic7);
		gs.draw(cubic8);
		gs.fill(cubic8);
		gs.fillRect(41, 41, 44, 44);
		
		gs.dispose();
		bufferedImage.flush();
		
		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 7;

	}

	public static int canvas8(int redout, int greenout, int blueout, int redin, int greenin, int bluein) {

		// 生成二维码绘制背景图，并设置颜色
		BufferedImage bufferedImage = new BufferedImage(130, 130, BufferedImage.TYPE_INT_RGB);
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, 130, 130);
		// 设置抗锯齿
		gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		int[] px1 = new int[] { 10, 115, 115, 15 };
		int[] py1 = new int[] { 10, 15, 115, 115 };
		int[] px2 = new int[] { 25, 100, 100, 30 };
		int[] py2 = new int[] { 25, 30, 100, 100 };
		int[] px3 = new int[] { 40, 85, 85, 42 };
		int[] py3 = new int[] { 40, 42, 85, 85 };

		gs.setColor(new Color(redout,greenout,blueout)); // 马眼
		gs.fillPolygon(px1, py1, px1.length);
		gs.setColor(Color.WHITE);
		gs.fillPolygon(px2, py2, px2.length);
		gs.setColor(new Color(redin, greenin, bluein));
		gs.fillPolygon(px3, py3, px3.length);
		gs.dispose();
		bufferedImage.flush();

		File imgFile = new File("./res//image.png");
		try {
			ImageIO.write(bufferedImage, "png", imgFile);

			// BufferedImage buffImage2 = ImageIO.read(new
			// FileInputStream("res/image.png"));
			// ShapeCanvas.rotateImage(buffImage2, 180);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 8;

	}

	public static void rotateImage(final BufferedImage bufferedimage, final int degree) {
		int w = bufferedimage.getWidth();// 得到图片宽度。
		int h = bufferedimage.getHeight();// 得到图片高度。
		int type = bufferedimage.getColorModel().getTransparency();// 得到图片透明度。
		BufferedImage img;// 空的图片。
		Graphics2D graphics2d;// 空的画笔。
		(graphics2d = (img = new BufferedImage(w, h, type)).createGraphics())
				.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);// 旋转，degree是整型，度数，比如垂直90度。
		graphics2d.drawImage(bufferedimage, 0, 0, null);// 从bufferedimagecopy图片至img，0,0是img的坐标。
		graphics2d.dispose();

		if (degree == 90) {
			File imgFile = new File("./res//image2.png");
			try {
				ImageIO.write(img, "png", imgFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (degree == 270) {
			File imgFile = new File("./res//image3.png");
			try {
				ImageIO.write(img, "png", imgFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (degree == 180) {
			File imgFile = new File("./res//image.png");
			try {
				ImageIO.write(img, "png", imgFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (degree == -90) {
			File imgFile = new File("./res//image.png");
			try {
				ImageIO.write(img, "png", imgFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
