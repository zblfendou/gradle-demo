
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 图片加水印，设置透明度
 * http://blog.csdn.net/hfmbook
 * @author Gary
 * 创建日期：2014年12月16日 22:45:17
 */
public class ImageAddWaterMark {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String srcImgPath = "d:/2.png";
		String iconPath = "d:/shuiyin2.png";
		String targerPath = "d:/c.png" ;
		// 给图片添加水印
		ImageAddWaterMark.markImageByIcon(iconPath, srcImgPath, targerPath);
	}
	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * @param iconPath 水印图片路径
	 * @param srcImgPath 源图片路径
	 * @param targerPath 目标图片路径
	 */
	public static void markImageByIcon (String iconPath, String srcImgPath,
	                                    String targerPath) {
		OutputStream os = null;
		try {
			BufferedImage srcImg = ImageIO.read(new File(srcImgPath));
			int srcImgWidth = srcImg.getWidth ();
			int srcImgHeight = srcImg.getHeight ();
			BufferedImage buffImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			Graphics2D g = buffImg.createGraphics();

			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g.drawImage(srcImg.getScaledInstance(srcImgWidth, srcImgHeight, Image.SCALE_SMOOTH), 0, 0, null);

			// 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
			BufferedImage imgIcon = ImageIO.read(new File(iconPath));
			// 得到Image对象。
			int waterMarkWidth = imgIcon.getWidth ();
			int waterMarkHeight = imgIcon.getHeight ();
			float alpha = 0.3f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
			// 表示水印图片的位置
			g.drawImage(imgIcon, (srcImgWidth-waterMarkWidth)/2,(srcImgHeight-waterMarkHeight)/2, waterMarkWidth,waterMarkHeight, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			os = new FileOutputStream(targerPath);
			// 生成图片
			ImageIO.write(buffImg, "png", os);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
} 