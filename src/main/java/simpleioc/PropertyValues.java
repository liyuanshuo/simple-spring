package simpleioc;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Here is the class description
 *
 * @author : liyuanshuo
 * @version : 1.0.0
 * @date : 2021/5/11 21:14
 */
@Data
@NoArgsConstructor
public class PropertyValues {
    private final HashSet<PropertyValue> propertyValueSet = new LinkedHashSet<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        /* 这里可以对重复的property进行判断，直接使用List做不到这一点 */
        propertyValueSet.add(propertyValue);
    }
}
