package com.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by Administrator on 2016.5.12.
 * https://github.com/coobird/thumbnailator
 */
public class ImageUtils implements Serializable {
	private static final long serialVersionUID = 4942746754260928924L;

	/**
	 * 裁切图片
	 * @param width
	 * 		宽度
	 * @param height
	 * 		长度
	 * @param sourceImg
	 * 		原图
	 * @param outImg
	 * 		裁切后图
	 * @throws IOException
	 */
	public static void cutImg (int width, int height, String sourceImg, String outImg) throws IOException {
		Thumbnails.of (sourceImg).height (height).width (width).toFile (outImg);
	}

	/**
	 * 添加水印
	 * @param sourceImg
	 * 		原图
	 * @param waterImg
	 * 		水印图
	 * @param outImg
	 * 		添加水印后图
	 * @param scale
	 * 		缩率图比例
	 * @param positions
	 * 		位置
	 * @param opacity
	 * 		透明度
	 * @param quality
	 * 		图片质量
	 * @throws IOException
	 */
	public static void AddWaterMark (String sourceImg, String waterImg, String outImg, double scale, Positions positions, float opacity, double quality) throws IOException {
		BufferedImage bufferedImage = ImageIO.read (new File (sourceImg));
		Thumbnails.of (bufferedImage).scale (scale)
				.watermark (positions, ImageIO.read (new File (waterImg)), opacity)
				.outputQuality (quality)
				.toFile (new File (outImg));
	}

	/**
	 * 转化图片格式
	 * @param sourceImg
	 * 		原图
	 * @param changedFormat
	 * 		要转化的格式
	 * @param outImg
	 * 		转化后的图片
	 * @throws IOException
	 */
	public static void changeImgFormat (String sourceImg, String changedFormat, String outImg) throws IOException {
		Thumbnails.of (sourceImg).size (1280, 1024).outputFormat (changedFormat).toFile (outImg);
	}

	/**
	 * 旋转
	 * @param sourceImg
	 * 		原图
	 * @param rotate
	 * 		(角度),正数：顺时针 负数：逆时针
	 * @param outImg
	 * 		旋转后图
	 * @throws IOException
	 */
	public static void whirlImg (String sourceImg, double rotate, String outImg) throws IOException {
		Thumbnails.of (sourceImg).size (1280, 1024).rotate (rotate).toFile (outImg);
	}

	/**
	 * 指定大小进行缩放
	 * @param sourceImg
	 * 		原图
	 * @param outImg
	 * 		缩放后图
	 * @param width
	 * 		宽度
	 * @param height
	 * 		长度
	 * @throws IOException
	 * @ size(width,height) 若图片横比200小，高比300小，不变
	 * 若图片横比200小，高比300大，高缩小到300，图片比例不变 若图片横比200大，高比300小，横缩小到200，图片比例不变
	 * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
	 */
	public static void specifySize (String sourceImg, String outImg, int width, int height) throws IOException {
		Thumbnails.of (sourceImg).size (width, height).toFile (outImg);

	}

}
