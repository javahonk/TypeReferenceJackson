package javahonk.model.typereference;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE
)
/**
 * @author JavaHonk 1/24/2021 2:43 PM
 */
public class TypeReferenceBody<T extends Event, R extends Order> implements Serializable {

    private T Event;
    private List<R> orders;

    public T getEvent() {
        return Event;
    }

    public void setEvent(T event) {
        Event = event;
    }

    public List<R> getOrders() {
        return orders;
    }

    public void setOrders(List<R> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "TypeReferereceBody{" +
                "Event=" + Event +
                ", orders=" + orders +
                '}';
    }
}
