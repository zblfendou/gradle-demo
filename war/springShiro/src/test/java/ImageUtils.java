import net.coobird.thumbnailator.*;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by Administrator on 2016.5.12.
 */
public class ImageUtils {
	@Test
	public void test(){
		try {
			Thumbnails.of ("d:/2.png").height (500).width (600).toFile ("d:/abc.png");
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}

	@Test
	public void testAddWaterMark () {
		try {
			File file = new File ("d:/2.png");
			BufferedImage bufferedImage = ImageIO.read (file);
			Thumbnails.of(bufferedImage).scale (1)
					.watermark(Positions.TOP_LEFT, ImageIO.read(new File("d:/shuiyin2.png")), 0.5f)
					.outputQuality(0.8)
					.toFile(new File("image-with-watermark.jpg"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}

	@Test
	public void testThumbnail () {

		try {
			BufferedImage originalImage = ImageIO.read(new File("d:/2.png"));

			Thumbnails.of(originalImage).scale(0.5).toFile (new File ("abc.png"));
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}
}
