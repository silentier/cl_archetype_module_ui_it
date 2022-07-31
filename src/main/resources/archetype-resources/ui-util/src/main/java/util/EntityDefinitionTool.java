package ${package}.util;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityDefinitionTool {

    private final static List<String> methodPermited = Arrays.asList("name",
            "length","hashCode","nullable","precision","unique","updatable","insertable");

    public static Map<String,Object> getEntityDefinition(Class clazz) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> retorno = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        Object[] params = {};

        Map<String,Object> map = new HashMap<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);
                Map<String,Object> mapColumn = new HashMap<>();
                Method[] methods = column.getClass().getMethods();

                for (Method method : methods) {
                    if (method.getParameters().length == 0 && methodPermited.contains(method.getName())) {
                        mapColumn.put(method.getName() , method.invoke(column, params));
                    }
                }

                map.put(column.name(), mapColumn);
            }
        }

        return map;
    }
}
