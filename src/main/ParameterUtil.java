package onnuri.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

public class Parameterutil {

  public static boolean isEmpty(Object... args) {
    if(args == null) {
      return true;
    }

    for(Object arg: args) {
      if(arg == null) {
        return true;
      } else if(arg instanceof String && StringUtils.isBlank((String)arg)) {
        return true;
      } else if(arg instanceof Integer && (Integer)arg == 0) {
        return true;
      } else if(arg instanceof Long && (Long) arg == 0) {
        return true;
//      } else if(arg instanceof MultipartFile && ((MultipartFile)args).isEmpty()) {
//      } else if(arg instanceof MultipartFile) {
//        return true;
//      } else if(arg instanceof Collection && CollectionUtils.isEmpty((Collection<?>)arg)) {
      } else if(arg instanceof Collection) {
        return true;
      }

    }
    return false;
  }

  public static void checkParameterEmpty(Object... args) {
    if(isEmpty(args))
      throw new RuntimeException();
  }
}
