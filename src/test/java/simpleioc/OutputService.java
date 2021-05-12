package simpleioc;

import lombok.Data;
import org.junit.jupiter.api.Assertions;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/12 17:53
 */
@Data
public class OutputService {

    private HelloWordService helloWordService;

    public void output(String text) {
        Assertions.assertNotNull(helloWordService);
        System.out.println(text);
    }
}
