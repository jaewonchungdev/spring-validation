package hello.itemservice.validation;

import org.junit.jupiter.api.Test;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.*;

public class MessageCodesResolverTest {
    MessageCodesResolver messageCodesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject(){
        String[] messageCodes = messageCodesResolver.resolveMessageCodes("required", "item");

        assertThat(messageCodes)
                .contains("required.item")
                .contains("required");
    }

    @Test
    void messageCodesResolverField(){
        String[] messageCodes = messageCodesResolver.resolveMessageCodes("required", "item", "itemName", String.class);

        assertThat(messageCodes)
                .contains("required.item.itemName")
                .contains("required.itemName")
                .contains("required");
    }

}
