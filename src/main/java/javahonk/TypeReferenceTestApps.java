package javahonk;

import com.fasterxml.jackson.core.type.TypeReference;
import javahonk.model.typereference.*;
import javahonk.util.CustomObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Javahonk 1/23/2021 10:31 PM
 */
public class TypeReferenceTestApps {

    public static void main(String args[]) {

        CustomObjectMapper customObjectMapper = new CustomObjectMapper();
        try {

            TypeReferenceBody typeReferenceBody = new TypeReferenceBody();
            Event event = new Event();
            event.setEventType("Event Type");
            Header header = new Header();
            header.setCorrelationId("123654");
            header.setMsg("Sample Message");
            event.setHeader(header);
            typeReferenceBody.setEvent(event);
            Order order = new Order();
            order.setOrderID("995623");
            order.setOrderType("Order Type");
            List<Order> orderList = new ArrayList<>();
            orderList.add(order);
            typeReferenceBody.setOrders(orderList);
            TypeReferenceMessage typeReferenceMessage = new TypeReferenceMessage();
            List<TypeReferenceBody> typeReferenceBodyList = new ArrayList<>();
            typeReferenceBodyList.add(typeReferenceBody);
            typeReferenceMessage.setBody(typeReferenceBodyList);
            typeReferenceMessage.setHeader(header);

            String jsonString = customObjectMapper.objectToJson(typeReferenceMessage);

            TypeReferenceMessage typeReferenceMessageConverted = customObjectMapper.jsonToObject(jsonString, getTypeReference());
            System.out.println(typeReferenceMessageConverted);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TypeReference getTypeReference() {
        return new TypeReference<TypeReferenceMessage<Event, Order>>() {};
    }
}
