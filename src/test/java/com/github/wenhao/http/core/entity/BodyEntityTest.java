package com.github.wenhao.http.core.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.http.core.model.HttpRequest;
import org.junit.Test;

public class BodyEntityTest
{

    @Test
    public void should_be_able_to_get_body_entity() throws Exception
    {
        // given
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.setBody("teset");


        // when
        BodyEntity bodyEntity = new BodyEntity();


        // then
        assertThat(bodyEntity.isApplicable(httpRequest), is(true));
    }
}
