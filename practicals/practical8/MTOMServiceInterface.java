package practicals.practical8;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.awt.Image;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface MTOMServiceInterface {
    // upload image to server
    @WebMethod String uploadImage(Image data);
	
    // download a image from server
    @WebMethod Image downloadImage(String name);
}