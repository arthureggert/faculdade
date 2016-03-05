package financeiro.domain.logic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import javax.inject.Qualifier;
import org.apache.deltaspike.partialbean.api.PartialBeanBinding;
import financeiro.domain.logic.AdminRules.Annotation;
import financeiro.domain.logic.AdminRules.Binding;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Short-circuit implementation of Rules for admin role, returns true for all.
 */
@Binding
// Can't use Typed due to DELTASPIKE-739
// @Typed(AdminRules.class)
@Annotation
@SuppressWarnings("cdi-target")
public abstract class AdminRules implements Rules {

    private static final long serialVersionUID = 1L;

    @Qualifier
    @Retention(RUNTIME)
    @Target(ElementType.TYPE)
    public static @interface Annotation {
    }
    
    @Retention(RUNTIME)
    @Target(ElementType.TYPE)
    @PartialBeanBinding
    protected static @interface Binding {
    }

    @Binding
    protected static class Handler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return true;
        }

    }

}
