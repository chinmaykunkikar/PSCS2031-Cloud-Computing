package practicals.practical8;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;

// for downloading image
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

// properties file
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class MTOMServiceClient {
    public static void main(String args[]) throws Exception {
        URL url = new URL("http://localhost:9747/mtom?wsdl");
		
		// open config.properties file
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream("./practicals/practical8/config.properties")) {
			prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		// load properties from the config file
		String filePath = prop.getProperty("path");
		String uploadImage = prop.getProperty("uploadimage");
		String downloadImage = prop.getProperty("downloadimage");
		
		/*
		 * If you don't wish to use config.properties file,
		 * you should uncomment the following code:
		 * NOTE: Please comment the code above from "open config.properties file" comment upto this comment
		 *
		 * String filePath = "./practicals/practical8/";
		 * String uploadImage = "uploadthisimage.png";
		 * String downloadImage = "downloadthisimage.png";
		 */

        /*
         * Qualified name of the service
         * 1st arg is the service URI
         * 2nd is the service name published in the WSDL
         */
        QName qname = new QName("http://practical8.practicals/", "MTOMServiceImplementationService");

        // Create, in effect, a factory for the service
        Service service = Service.create(url, qname);

        //Extract the endpoint interface, the service "port"
        MTOMServiceInterface MTOMInterface = service.getPort(MTOMServiceInterface.class);

        // enable MTOM
        BindingProvider bp = (BindingProvider) MTOMInterface;
        SOAPBinding binding = (SOAPBinding) bp.getBinding();
        binding.setMTOMEnabled(true);

        /* Upload a file */
        String status = MTOMInterface.uploadImage(ImageIO.read(new File(filePath + uploadImage)));
        System.out.println("MTOMServiceInterface.uploadImage(): " + status);

        /* Download a file */
        Image image = MTOMInterface.downloadImage(downloadImage);
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
        System.out.println("MTOMServiceInterface.downloadImage(): Download successful");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}