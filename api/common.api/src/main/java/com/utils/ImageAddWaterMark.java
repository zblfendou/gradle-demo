package com.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 图片加水印，设置透明度
 */
public class ImageAddWaterMark implements Serializable {
	private static final long serialVersionUID = 5735087062307037031L;

	private static final String SOURCE_IMG = "/img/sourceimg.png";
	private static final String WATERMARK_IMG = "/img/watermark.png";
	private static final String ADDWATERMARK_IMG = "/addWaterMark.png";

	/**
	 * @param args
	 */
	public static void main (String[] args) {
		ImageAddWaterMark imageAddWaterMark = new ImageAddWaterMark ();
		// 给图片添加水印
		imageAddWaterMark.markImageByIcon (WATERMARK_IMG, SOURCE_IMG, ADDWATERMARK_IMG);
	}

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * @param iconPath
	 * 		水印图片路径
	 * @param srcImgPath
	 * 		源图片路径
	 * @param targerPath
	 * 		目标图片路径
	 */
	public void markImageByIcon (String iconPath, String srcImgPath,
	                             String targerPath) {
		OutputStream os = null;
		try {
			BufferedImage srcImg = ImageIO.read (this.getClass ().getResourceAsStream (srcImgPath));
			int srcImgWidth = srcImg.getWidth ();
			int srcImgHeight = srcImg.getHeight ();
			BufferedImage buffImg = new BufferedImage (srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			Graphics2D g = buffImg.createGraphics ();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint (RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage (srcImg.getScaledInstance (srcImgWidth, srcImgHeight, Image.SCALE_SMOOTH), 0, 0, null);

			// 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
			BufferedImage imgIcon = ImageIO.read (this.getClass ().getResourceAsStream (iconPath));
			// 得到Image对象。
			int waterMarkWidth = imgIcon.getWidth ();
			int waterMarkHeight = imgIcon.getHeight ();
			float alpha = 0.3f; // 透明度
			g.setComposite (AlphaComposite.getInstance (AlphaComposite.SRC_ATOP, alpha));
			// 表示水印图片的位置
			g.drawImage (imgIcon, (srcImgWidth - waterMarkWidth) / 2, (srcImgHeight - waterMarkHeight) / 2, waterMarkWidth, waterMarkHeight, null);
			g.setComposite (AlphaComposite.getInstance (AlphaComposite.SRC_OVER));
			g.dispose ();
			os = new FileOutputStream (targerPath);
			// 生成图片
			ImageIO.write (buffImg, "png", os);
		} catch (Exception e) {
			e.printStackTrace ();
		} finally {
			try {
				if (null != os)
					os.close ();
			} catch (Exception e) {
				e.printStackTrace ();
			}
		}
	}
} 