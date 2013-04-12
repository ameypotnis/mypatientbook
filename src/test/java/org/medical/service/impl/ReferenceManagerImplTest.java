package org.medical.service.impl;

import com.mysema.query.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medical.dao.mongo.ReferenceDao;
import org.medical.model.mongo.Reference;
import org.medical.model.mongo.ReferenceKey;
import org.medical.service.ReferenceManager;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReferenceManagerImplTest extends BaseManagerMockTestCase {
    @Mock
    ReferenceDao repository;
    @Mock Predicate predicate;
    @InjectMocks
    ReferenceManager manager = new ReferenceManagerImpl();

    @Test public void addShouldCallRepositorySave() {
        Reference reference = new Reference(ReferenceKey.DIAGNOSIS);
        manager.add(reference);
        verify(repository).save(reference);
    }

}
