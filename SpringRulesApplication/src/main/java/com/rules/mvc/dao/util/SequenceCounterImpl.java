package com.rules.mvc.dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.SequenceCounterInfo;

@Component
public class SequenceCounterImpl implements SequenceCounter {
	
	 @Autowired
	 private MongoOperations mongoOperation;
	 
	 protected void createCounters(SequenceCounterInfo counters){
        mongoOperation.save(counters);
    }
	 
    public void removeCounters(SequenceCounterInfo counters){
        mongoOperation.remove(counters);
    }

	protected SequenceCounterInfo findCounterByName(String key){
        Query query = new Query(Criteria.where("_id").is(key));
        return mongoOperation.findOne(query,SequenceCounterInfo.class);
    }

    @Override
    public long getNextSequence(String key, long seqNum) {
        Query query = new Query(Criteria.where("_id").is(key));
        
        //increase sequence id by 1
        Update update = new Update();
        update.inc("seq", 1);

        //return new increased id
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);

        SequenceCounterInfo counters =
                mongoOperation.findAndModify(query, update, options, SequenceCounterInfo.class);

        if (counters == null) {
            //if this the first time, create the collection in DB
            mongoOperation.save(getCounters(key, seqNum));
            counters =  mongoOperation.findAndModify(query, update, options, SequenceCounterInfo.class);
        }

        return counters.getSeq();

    }


    private SequenceCounterInfo getCounters(String key, long seqNum) {
        return new SequenceCounterInfo (key, seqNum);
    }
}
