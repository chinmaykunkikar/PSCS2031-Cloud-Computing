
package practicals.practical3.CMatrix;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MatrixInterface", targetNamespace = "http://practical3.practicals/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MatrixInterface {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<practicals.practical3.CMatrix.IntArray>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "multiply", targetNamespace = "http://practical3.practicals/", className = "practicals.practical3.CMatrix.Multiply")
    @ResponseWrapper(localName = "multiplyResponse", targetNamespace = "http://practical3.practicals/", className = "practicals.practical3.CMatrix.MultiplyResponse")
    @Action(input = "http://practical3.practicals/MatrixInterface/multiplyRequest", output = "http://practical3.practicals/MatrixInterface/multiplyResponse")
    public List<IntArray> multiply(
        @WebParam(name = "arg0", targetNamespace = "")
        List<IntArray> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        List<IntArray> arg1);

}
