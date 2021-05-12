package simpleioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 16:09
 */
public interface Resource {
    /**
     * 内部定位资源接口
     *
     * @return InputStream
     * @throws IOException IO异常
     */
    InputStream getInputStream() throws IOException;
}
