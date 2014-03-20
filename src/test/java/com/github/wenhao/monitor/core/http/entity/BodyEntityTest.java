package com.github.wenhao.monitor.core.http.entity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.github.wenhao.monitor.core.http.model.Request;
import org.junit.Test;

public class BodyEntityTest
{

    @Test
    public void should_be_able_to_get_body_entity() throws Exception
    {
        // given
        Request request = new Request();
        request.setBody("teset");


        // when
        BodyEntity bodyEntity = new BodyEntity();


        // then
        assertThat(bodyEntity.isApplicable(request), is(true));
    }
}
