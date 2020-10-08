package hr.com.vgv.examples.test.assertions;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Patient
{
    private final String id;
    private final String name;
    private final String nurse;
    private final boolean active;
}
