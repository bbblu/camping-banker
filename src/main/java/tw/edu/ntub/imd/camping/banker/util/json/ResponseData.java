package tw.edu.ntub.imd.camping.banker.util.json;

import com.fasterxml.jackson.databind.JsonNode;

@FunctionalInterface
public interface ResponseData {
    JsonNode getData();
}
