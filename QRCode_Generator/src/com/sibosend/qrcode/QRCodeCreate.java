package com.sibosend.qrcode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QRCodeCreate {

	// 生成点的大小
	private static int WIDTH = 15;
	private static BufferedImage bufferedImage;
	private static Graphics2D gs;
	// private static int DEFAULT_WIDTH;

	/*
	 * 生成二维码
	 */
	public void qrCodeEncode(String content, String qrCodePath, String logoPath, int conType, int qrType, int red,
			int grenn, int blue, int redout, int greenout, int blueout, int redin, int greenin, int bluein)
			throws IOException {
		Qrcode qrcode = new Qrcode();
		/*
		 * 错误修正容量 L水平 7% 的字码可被修正 M水平 15% 的字码可被修正 Q水平 25% 的字码可被修正 H水平 30% 的字码可被修正
		 */
		qrcode.setQrcodeErrorCorrect('M'); // L','M','Q','H'
		// 编码格式
		qrcode.setQrcodeEncodeMode('B'); // "N","A"
		byte[] len = content.getBytes();
		if (len.length < 29) {
			qrcode.setQrcodeVersion(3);// 设置版本，版本越高，容纳信息量越大，范围: 0-20
			// 生成二维码绘制背景图
			bufferedImage = new BufferedImage(455, 455, BufferedImage.TYPE_INT_RGB);
			gs = bufferedImage.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 455, 455);
		} else if (len.length > 28) {
			qrcode.setQrcodeVersion(5);
			bufferedImage = new BufferedImage(463, 463, BufferedImage.TYPE_INT_RGB);
			gs = bufferedImage.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 463, 463);
		}
		byte[] buffer = null;
		try {
			buffer = content.getBytes("utf-8");
			boolean[][] bRect = qrcode.calQrcode(buffer); // 计算二维码,结果用布尔数组表示，用于绘制
			// 设置抗锯齿
			gs.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			gs.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

			QRType(qrType, redout, greenout, blueout, redin, greenin, bluein);
			Image eyeImage = ImageIO.read(new File("./res/image.png"));
			BufferedImage buffImage2 = ImageIO.read(new FileInputStream("./res/image.png"));
			ShapeCanvas.rotateImage(buffImage2, 90);
			Image eyeImage2 = ImageIO.read(new File("./res/image2.png"));
			BufferedImage buffImage3 = ImageIO.read(new FileInputStream("./res/image.png"));
			ShapeCanvas.rotateImage(buffImage3, 270);
			Image eyeImage3 = ImageIO.read(new File("./res/image3.png"));

			gs.setColor(new Color(red, grenn, blue));
			// 绘制二维码
			if (buffer.length > 0 && len.length < 29) {
				for (int i = 0; i < bRect.length; i++) {
					for (int j = 0; j < bRect.length; j++) {
						if (bRect[j][i]) {
							if (j < WIDTH / 2 && i < WIDTH / 2) {
								gs.drawImage(eyeImage, 4, 4, 125, 125, null);

							} else if (j > 20 && i < WIDTH / 2) {
								gs.drawImage(eyeImage2, 328, 4, 125, 125, null);

							} else if (j < WIDTH / 2 && i > 20) {
								gs.drawImage(eyeImage3, 4, 328, 125, 125, null);

							} else {
								if (conType > 0) {
									gs.fillRoundRect(j * WIDTH + 10, i * WIDTH + 10, WIDTH, WIDTH, 2 * conType,
											2 * conType);
								} else {
									if (i == 0 && isLeft(bRect, j, i)) {
										gs.fillRoundRect((j - 1) * WIDTH + 10, i * WIDTH + 10, WIDTH, WIDTH, 13, 13);
										gs.fillRect((j - 1) * WIDTH + 15, i * WIDTH + 10, WIDTH, WIDTH);
										gs.fillRoundRect(j * WIDTH + 10, i * WIDTH + 10, WIDTH, WIDTH, 13, 13);
									}
									if ((i == 0 && isAroundI(bRect, j, i)) || (j > 7 && j < 28 && i == 28 && isAround(bRect, j, i))) {
										gs.fillOval(j * WIDTH + 10, i * WIDTH + 10, WIDTH + 2, WIDTH + 2);
									}
									if (i > 7 && i < 21 && isUpJ(bRect, j, i)) {
										gs.fillRoundRect(j * WIDTH + 10, (i - 1) * WIDTH + 10, WIDTH, WIDTH, 13, 13);
										gs.fillRect(j * WIDTH + 10, (i - 1) * WIDTH + 15, WIDTH, WIDTH);
										gs.fillRoundRect(j * WIDTH + 10, i * WIDTH + 10, WIDTH, WIDTH, 13, 13);
									}
									if (i > 7 && i < 21 && j == 0 && isAroundJ(bRect, j, i)) {
										gs.fillOval(j * WIDTH + 10, i * WIDTH + 10, WIDTH + 2, WIDTH + 2);
									}
									if (j == 28 && isRight(bRect, j, i)) {
										gs.fillOval(j * WIDTH + 10, i * WIDTH + 10, WIDTH + 2, WIDTH + 2);
									}
									if ((j > 0 && j < 28 && i > 0 && i < 28) && isAroundNo(bRect, j, i)) {
										gs.fillOval(j * WIDTH + 10, i * WIDTH + 10, WIDTH + 2, WIDTH + 2);
									}
									if ((j > 0 && j <= 28 && i > 0 && i <= 28) && isAroundLeft(bRect, j, i)) {
										gs.fillRoundRect((j - 1) * WIDTH + 10, i * WIDTH + 10, WIDTH, WIDTH, 13, 13);
										gs.fillRect((j - 1) * WIDTH + 15, i * WIDTH + 10, WIDTH, WIDTH);
										gs.fillRoundRect(j * WIDTH + 10, i * WIDTH + 10, WIDTH, WIDTH, 13, 13);
									}
									if ((j > 0 && j <= 28 && i > 0 && i <= 28) && isAroundUp(bRect, j, i)) {
										gs.fillRoundRect(j * WIDTH + 10, (i - 1) * WIDTH + 10, WIDTH, WIDTH, 13, 13);
										gs.fillRect(j * WIDTH + 10, (i - 1) * WIDTH + 15, WIDTH, WIDTH);
										gs.fillRoundRect(j * WIDTH + 10, i * WIDTH + 10, WIDTH, WIDTH, 13, 13);
									}
									if (i > 0 && j < 28 && isRightUp(bRect, j, i)) {
										gs.setStroke(new BasicStroke(7));
										gs.drawLine(j * WIDTH + 20, i * WIDTH + 16, (j + 1) * WIDTH + 20,
												(i - 1) * WIDTH + 15);
									}
									if (i > 0 && j > 0 && isLeftUp(bRect, j, i)) {
										gs.setStroke(new BasicStroke(7));
										gs.drawLine(j * WIDTH + 10, i * WIDTH + 10, j * WIDTH, i * WIDTH);
									}
									if (i < 27 && j > 0 && j < 27 && aroundCircle(bRect, j, i)) {
										gs.setStroke(new BasicStroke(7));
										gs.drawOval(j * WIDTH + 7, (i + 1) * WIDTH + 7, 20, 20);
									}
								}
							}
						}

					}

				}
			} else if (buffer.length > 0 && len.length > 28) {
				for (int i = 0; i < bRect.length; i++) {
					for (int j = 0; j < bRect.length; j++) {
						if (bRect[j][i]) {
							if (j < WIDTH / 2 && i < WIDTH / 2) {
								gs.drawImage(eyeImage, 3, 3, 100, 100, null);

							} else if (j > 35 && i < WIDTH / 2) {
								gs.drawImage(eyeImage2, 362, 3, 100, 100, null);

							} else if (j < WIDTH / 2 && i > 35) {
								gs.drawImage(eyeImage3, 3, 362, 100, 100, null);

							} else {
								if (conType > 0) {
									gs.fillRoundRect(j * 12 + 10, i * 12 + 10, 13, 13, 2 * conType, 2 * conType);
								}else {
									if (i == 0 && isLeft(bRect, j, i)) {
										gs.fillRoundRect((j - 1) * 12 + 10, i * 12 + 10, 13, 13, 11, 11);
										gs.fillRect((j - 1) * 12 + 15, i * 12 + 10, 13, 13);
										gs.fillRoundRect(j * 12 + 10, i * 12 + 10, 13, 13, 11, 11);
									}
									if ((i == 0 && isAroundI(bRect, j, i)) || (j > 7 && j < 36 && i == 36 && isAround(bRect, j, i))) {
										gs.fillOval(j * 12 + 10, i * 12 + 10, 13 + 2, 13 + 2);
									}
									if (i > 7 && i < 36 && isUpJ(bRect, j, i)) {
										gs.fillRoundRect(j * 12 + 10, (i - 1) * 12 + 10, 13, 13, 11, 11);
										gs.fillRect(j * 12 + 10, (i - 1) * 12 + 15, 13, 13);
										gs.fillRoundRect(j * 12 + 10, i * 12 + 10, 13, 13, 11, 11);
									}
									if (i > 7 && i < 36 && j == 0 && isAroundJ(bRect, j, i)) {
										gs.fillOval(j * 12 + 10, i * 12 + 10, 13 + 2, 13 + 2);
									}
									if (i > 7 && i < 36 && j == 36 && isRight(bRect, j, i)) {
										gs.fillOval(j * 12 + 10, i * 12 + 10, 13 + 2, 13 + 2);
									}
									if (j > 0 && j < 36 && i > 0 && i < 36 && isAroundNo(bRect, j, i)) {
										gs.fillOval(j * 12 + 10, i * 12 + 10, 13 + 2, 13 + 2);
									}
									if ((j > 0 && j <= 36 && i > 0 && i <= 36) && isAroundLeft(bRect, j, i)) {
										gs.fillRoundRect((j - 1) * 12 + 10, i * 12 + 10, 13, 13, 11, 11);
										gs.fillRect((j - 1) * 12 + 15, i * 12 + 10, 13, 13);
										gs.fillRoundRect(j * 12 + 10, i * 12 + 10, 13, 13, 11, 11);
									}
									if ((j > 0 && j <= 36 && i > 0 && i <= 36) && isAroundUp(bRect, j, i)) {
										gs.fillRoundRect(j * 12 + 10, (i - 1) * 12 + 10, 13, 13, 11, 11);
										gs.fillRect(j * 12 + 10, (i - 1) * 12 + 15, 13, 13);
										gs.fillRoundRect(j * 12 + 10, i * 12 + 10, 13, 13, 11, 11);
									}
									if (i > 0 && j < 36 && isRightUp(bRect, j, i)) {
										gs.setStroke(new BasicStroke(6));
										gs.drawLine(j * 12 + 20, i * 12 + 13, (j + 1) * 12 + 19,
												(i - 1) * 12 + 14);
									}
									if (i > 0 && j > 0 && isLeftUp(bRect, j, i)) {
										gs.setStroke(new BasicStroke(6));
										gs.drawLine(j * 12 + 10, i * 12 + 10, (j-1) * 12 + 15, (i-1) * 12 + 15);
									}
									if (i < 35 && j > 0 && j < 35 && aroundCircle(bRect, j, i)) {
										gs.setStroke(new BasicStroke(5));
										gs.drawOval(j * 12 + 10, (i + 1) * 12 + 9, 13, 13);
									}
								}
							}
						}

					}

				}
			}

			if (!logoPath.equals("N") && !logoPath.equals("n")) {
				Image image = ImageIO.read(new File(logoPath));
				// 实例化一个Image对象。
				gs.drawImage(image, 153, 153, 153, 153, null);
			}
			gs.dispose();
			bufferedImage.flush();

			// 生成二维码QRCode图片
			File imgFile = new File(qrCodePath);
			ImageIO.write(bufferedImage, "png", imgFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("保存成功!");
	}

	private static boolean isLeft(boolean[][] bRect, int j, int i) {
		if (bRect[j - 1][i]) {
			return true;
		}
		return false;
	}

	private static boolean isUpJ(boolean[][] bRect, int j, int i) {
		if (bRect[j][i - 1]) {
			return true;
		}
		return false;
	}

	private static boolean isRight(boolean[][] bRect, int j, int i) {
		if (!bRect[j - 1][i] && !bRect[j][i + 1] && !bRect[j][i - 1]) {
			return true;
		}
		return false;
	}

	private static boolean isRightUp(boolean[][] bRect, int j, int i) {
		if (bRect[j][i] && bRect[j + 1][i - 1]) {
			return true;
		}
		return false;
	}

	private static boolean isLeftUp(boolean[][] bRect, int j, int i) {
		if (bRect[j][i] && bRect[j - 1][i - 1]) {
			return true;
		}
		return false;
	}

	private static boolean isAroundJ(boolean[][] bRect, int j, int i) {
		if (!bRect[j][i - 1] && !bRect[j][i + 1] && !bRect[j + 1][i]) {
			return true;
		}
		return false;
	}

	private static boolean isAroundI(boolean[][] bRect, int j, int i) {
		if (!bRect[j - 1][i] && !bRect[j + 1][i] && !bRect[j][i + 1]) {
			return true;
		}
		return false;
	}

	private static boolean isAround(boolean[][] bRect, int j, int i) {
		if (!bRect[j - 1][i] && !bRect[j + 1][i] && !bRect[j][i - 1]) {
			return true;
		}
		return false;
	}

	private static boolean aroundCircle(boolean[][] bRect, int j, int i) {
		if (bRect[j][i] && !bRect[j][i + 1] && bRect[j - 1][i + 1] && bRect[j + 1][i + 1] && bRect[j][i + 2]) {
			return true;
		}
		return false;
	}

	private static boolean isAroundNo(boolean[][] bRect, int j, int i) {
		if (!bRect[j - 1][i] && !bRect[j + 1][i] && !bRect[j][i - 1] && !bRect[j][i + 1]) {
			return true;
		}
		return false;
	}

	private static boolean isAroundLeft(boolean[][] bRect, int j, int i) {
		if (bRect[j - 1][i]) {
			return true;
		}
		return false;
	}

	private static boolean isAroundUp(boolean[][] bRect, int j, int i) {
		if (bRect[j][i - 1]) {
			return true;
		}
		return false;
	}

	private static void QRType(int qrType, int redout, int greenout, int blueout, int redin, int greenin, int bluein) {
		switch (qrType) {
		case 1:
			ShapeCanvas.canvas1(redout, greenout, blueout, redin, greenin, bluein);
			break;
		case 2:
			ShapeCanvas.canvas2(redout, greenout, blueout, redin, greenin, bluein);
			break;
		case 3:
			ShapeCanvas.canvas3(redout, greenout, blueout, redin, greenin, bluein);
			break;
		case 4:
			ShapeCanvas.canvas4(redout, greenout, blueout, redin, greenin, bluein);
			break;
		case 5:
			ShapeCanvas.canvas5(redout, greenout, blueout, redin, greenin, bluein);
			break;
		case 6:
			ShapeCanvas.canvas6(redout, greenout, blueout, redin, greenin, bluein);
			break;
		case 7:
			ShapeCanvas.canvas7(redout, greenout, blueout, redin, greenin, bluein);
			break;
		case 8:
			ShapeCanvas.canvas8(redout, greenout, blueout, redin, greenin, bluein);
			break;

		default:
			ShapeCanvas.canvas1(redout, greenout, blueout, redin, greenin, bluein);
			break;
		}
	}

}