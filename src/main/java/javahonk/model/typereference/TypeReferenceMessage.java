package javahonk.model.typereference;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE
)
/**
 * @author JavaHonk 1/24/2021 2:06 PM
 */
public class TypeReferenceMessage<T extends Event, R extends Order> implements Serializable {

    private Header header;
    private List<TypeReferenceBody<T, R>> body = new ArrayList<>();

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<TypeReferenceBody<T, R>> getBody() {
        return body;
    }

    public void setBody(List<TypeReferenceBody<T, R>> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "TypeReferenceMessage{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
