package com.polyglot.mobile.persistence.repository;

import com.polyglot.mobile.persistence.common.BaseMobilePersistenceIT;
import com.polyglot.mobile.persistence.common.MobileEnvironment;
import com.polyglot.mobile.persistence.entity.EnvironmentEntity;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Rajiv Singla on 9/23/2015.
 */
public class TodoRepositoryIT extends BaseMobilePersistenceIT {

    @Resource
    private EnvironmentRepository environmentRepository;

    @Test
    public void testFindByTitle() throws Exception {

        EnvironmentEntity environmentEntity = new EnvironmentEntity(MobileEnvironment.COMMON,"Common EnvironmentEntity");

        long existingEnvironmentsCount = environmentRepository.count();
        Assert.assertThat("There should be no Environment Entity before the test",existingEnvironmentsCount, is(0L));
        //Save environment entity in database
        EnvironmentEntity savedEntity = environmentRepository.save(environmentEntity);
        //Fetch it back from database
        List<EnvironmentEntity> mobileEnvironmentEntities = environmentRepository.findByName(MobileEnvironment.COMMON);
        Assert.assertThat(mobileEnvironmentEntities.size(), is(1));
        Assert.assertTrue("Saved and fetched Environment Entity must be same", environmentEntity.equals(mobileEnvironmentEntities.get(0)));

        System.out.println(mobileEnvironmentEntities);
    }
}