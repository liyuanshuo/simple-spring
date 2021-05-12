package simpleioc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 21:07
 */
@Data
@AllArgsConstructor
public class PropertyValue {
    private final String name;
    private final Object value;
}
