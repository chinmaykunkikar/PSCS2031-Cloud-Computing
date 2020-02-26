package practicals.practical8;

import java.util.Date;
import javax.jws.WebService;
import javax.imageio.ImageIO;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.WebServiceException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@MTOM
@WebService(endpointInterface = "practicals.practical8.MTOMServiceInterface")
public class MTOMServiceImplementation implements MTOMServiceInterface {
    public String filePath = "./practicals/practical8/imagedir/";
	public String uploadImage = "uploadedimage.png";

    public Image downloadImage(String fileName) {
        try {
            File image = new File("./practicals/practical8/" + fileName);
            return ImageIO.read(image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String uploadImage(Image data) {
        try {
            BufferedImage bImage = (BufferedImage) data;
            if (bImage != null) {
                // write to a local directory
                ImageIO.write(bImage, "png", new File(filePath + uploadImage));
                return "Upload successful";
            }
            throw new WebServiceException("Upload Failed");
        } catch (IOException e) {
            e.printStackTrace();
            throw new WebServiceException("Upload Failed with IOException");
        }
    }
}