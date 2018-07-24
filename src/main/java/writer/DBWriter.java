package writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Object[]> {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String sqlTemplate;
    int[] dataTypes;

    public DBWriter(){

    }

    public String getSqlTemplate() {
        return sqlTemplate;
    }

    public void setSqlTemplate(String sqlTemplate) {
        this.sqlTemplate = sqlTemplate;
    }


    @Override
    public void write(List<? extends Object[]> list) throws Exception {
        jdbcTemplate.batchUpdate(sqlTemplate, (List<Object[]>) list, dataTypes);
    }
}
