package cn.zh.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * ͼƬ������
 */
public class ImageUtils {

	private ImageUtils(){}
	
	private BufferedImage image = null;

	public void load(File imageFile) throws IOException {
		image = ImageIO.read(imageFile);
		System.out.print("ԭͼ�ߣ�"+image.getHeight());
	}

	public int getImageWidth() {
		return image.getWidth();
	}

	public int getImageHeight() {
		return image.getHeight();
	}

	//ͼƬ�ü�
	public void cutTo(int x,int  y,int tarWidth, int tarHeight) throws FileNotFoundException {
		if (image == null) {
			throw new FileNotFoundException(
					"image file not be load.please execute 'load' function agin.");
		}

		int iSrcWidth = getImageWidth(); // �õ�Դͼ��
		int iSrcHeight = getImageHeight(); // �õ�Դͼ��

		// ���ԴͼƬ�Ŀ�Ȼ�߶�С��Ŀ��ͼƬ�Ŀ�Ȼ�߶ȣ���ֱ�ӷ��س���
		if (iSrcWidth < tarWidth || iSrcHeight < tarHeight) {
			
			throw new RuntimeException("source image size too small.");
		}

		// ����Դͼ��Ŀ��ͼ�ĳߴ����
		double dSrcScale = iSrcWidth * 1.0 / iSrcHeight;
		double dDstScale = tarWidth * 1.0 / tarHeight;

		// ��ȷ�����óߴ�
		int iDstLeft, iDstTop, iDstWidth, iDstHeight;
		if (dDstScale > dSrcScale) { // Ŀ��ͼƬ��
			iDstWidth = iSrcWidth;
			iDstHeight = (int) (iDstWidth * 1.0 / dDstScale);
		} else { // Ŀ��ͼƬ��
			iDstHeight = iSrcHeight;
			iDstWidth = (int) (iDstHeight * dDstScale);
		}
		iDstLeft = (iSrcWidth - iDstWidth) / 2;
		iDstTop = (iSrcHeight - iDstHeight) / 2;

		// ����
		this.image = image
				.getSubimage(x, y, tarWidth, tarHeight);

	}

	/**
	 * 	//ͼƬ���� �������µ�ͼƬ
	 */
	public void zoomTo(int tarWidth, int tarHeight) {
		BufferedImage tagImage = new BufferedImage(tarWidth, tarHeight,
				BufferedImage.TYPE_INT_RGB); // ����ͼ��
		Image image = this.image.getScaledInstance(tarWidth, tarHeight,
				Image.SCALE_SMOOTH);
		Graphics g = tagImage.getGraphics();
		g.drawImage(image, 0, 0, null); // ����Ŀ��ͼ
		g.dispose();
		this.image = tagImage;

	}

	/**
	 * ����
	 * @param fileName
	 * @param formatName
	 * @throws IOException
	 */
	public void save(String fileName, String formatName) throws IOException {
		// д�ļ�
		FileOutputStream out = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(this.image, formatName, bos);// �����bos
			out = new FileOutputStream(fileName);
			out.write(bos.toByteArray()); // д�ļ�
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * //����ͼƬ �����µ�ͼƬ
	 */
	public static boolean zoomImage(String srcFile, String dstFile, int width,
			int height, String formatName) {
		try {
			ImageUtils zoom = new ImageUtils();
			zoom.load(new File(srcFile));
			zoom.zoomTo(width, height);
			zoom.save(dstFile, formatName);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	private static ImageUtils fromImageFile(File file) throws IOException {
		ImageUtils utils = new ImageUtils();
		utils.load(file);
		return utils;
	}

	/**
	 * ����ͼƬ
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static ImageUtils load(String fileName) throws IOException {
		File file = new File(fileName);
		return fromImageFile(file);
	}
	
	
//	public static void main(String[] args) {
//		String p =  "e:/090613221071ed5df7cf2bce72.jpg";
//		ImageUtils image , image2;
//		try {
//			image = ImageUtils.load(p);
//			//image.zoomImage(p, "e:/xxx.jpg", 500, 500, "jpg");
//			image.zoomTo(500, 500);
//			image.cutTo(50,50,100, 100);
//			image.save("e:/111.jpg", "jpg");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
