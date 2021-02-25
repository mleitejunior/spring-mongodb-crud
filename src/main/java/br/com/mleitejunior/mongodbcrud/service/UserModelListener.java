package br.com.mleitejunior.mongodbcrud.service;

import br.com.mleitejunior.mongodbcrud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class UserModelListener extends AbstractMongoEventListener<User> {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
//
//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<User> event) {
//        if (event.getSource().getId() < 1) {
//            event.getSource().setId(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME));
//        }
//    }
}
