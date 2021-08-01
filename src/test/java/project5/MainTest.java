
package project5;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author oscar
 */
public class MainTest {
    

    @Test
    @DisplayName("readFile() test")
    public void testReadFile() throws FileNotFoundException
    {
        System.out.println("readFile");
        Main main=new Main();
        File file=new File("expression.txt");
        assertNotNull(main.readFile(file));
    }
    
    //toDeque() returns void.
    
    
    //run() returns void.
}
