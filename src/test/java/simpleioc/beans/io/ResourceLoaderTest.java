package simpleioc.beans.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 16:52
 */
class ResourceLoaderTest {

    @Test
    public void resourceLoadTest() throws IOException {
        ResourceLoader loader = new ResourceLoader();
        Resource resource = loader.getResource("simpleioc.xml");
        InputStream stream = resource.getInputStream();
        Assertions.assertNotNull(stream);
    }

}
