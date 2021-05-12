package simpleioc;

import lombok.Data;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 19:32
 */
@Data
public class HelloWordService {

    private String text;

    private OutputService outputService;

    public void helloWord() {
        System.out.println("Hello Simple Spring!");
    }
}
