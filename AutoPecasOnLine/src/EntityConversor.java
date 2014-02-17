import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.autopecas.util.BaseEntity;

/**
 * 
 */

/**
 * @author Everson Lisboa
 *
 */
@FacesConverter(value = "entityConverter")
public class EntityConversor implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

    	if (value != null && !"".equals(value)) {
    		Object object = (Object)value;
            return object;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !"".equals(value)) {
            BaseEntity entity = (BaseEntity) value;

            //adiciona item como atributo do componente
//            this.addAttribute(component, entity);

            Long codigo = entity.getId();
            if (codigo != null) {
                return String.valueOf(codigo);
            }
        }
        return (String) value;
    }

    protected void addAttribute(UIComponent component, BaseEntity o) {
        String key = o.getId().toString(); //código da entidade como chave
        this.getAttributesFrom(component).put(key, o);
    }
  protected Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }

}
