package hr.com.vgv.printers;

import javax.json.JsonObject;

public interface Output<T>
{
    T print(JsonObject json);
}
