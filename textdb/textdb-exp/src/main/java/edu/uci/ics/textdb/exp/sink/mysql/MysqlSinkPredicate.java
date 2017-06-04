package edu.uci.ics.textdb.exp.sink.mysql;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import edu.uci.ics.textdb.exp.common.PredicateBase;
import edu.uci.ics.textdb.exp.common.PropertyNameConstants;

public class MysqlSinkPredicate extends PredicateBase{
	 private final String host;
	    private final Integer port;
	    private final String database;
	    private final String table;
	    private final String username;
	    private final String password;
	    private final Integer limit;
	    private final Integer offset;
	    
	    @JsonCreator
	    public MysqlSinkPredicate(
	            @JsonProperty(value = PropertyNameConstants.MYSQL_HOST, required = true)
	            String host,
	            @JsonProperty(value = PropertyNameConstants.MYSQL_PORT, required = true)
	            Integer port,
	            @JsonProperty(value = PropertyNameConstants.MYSQL_DATABASE, required = true)
	            String database,
	            @JsonProperty(value = PropertyNameConstants.MYSQL_TABLE, required = true)
	            String table,	            
	            @JsonProperty(value = PropertyNameConstants.MYSQL_USERNAME, required = true)
	            String username,
	            @JsonProperty(value = PropertyNameConstants.MYSQL_PASSWORD, required = true)
	            String password,
	            @JsonProperty(value = PropertyNameConstants.MYSQL_LIMIT, required = true)
	            Integer limit,
	            @JsonProperty(value = PropertyNameConstants.MYSQL_OFFSET, required = true)
	            Integer offset
	            ) {
	        this.host = host.trim();
	        this.port = port;
	        this.database = database.trim();
	        this.table = table.trim();
	        this.username = username.trim();	
	        this.password = password;	// Space should be legitimate password
	        this.limit = limit;
	        this.offset = offset;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_HOST)
	    public String getHost() {
	        return host;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_PORT)
	    public Integer getPort() {
	        return port;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_DATABASE)
	    public String getDatabase() {
	        return database;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_DATABASE)
	    public String getTable() {
	        return table;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_USERNAME)
	    public String getUsername() {
	        return username;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_PASSWORD)
	    public String getPassword() {
	        return password;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_LIMIT)
	    public Integer getLimit() {
	        return limit;
	    }
	    
	    @JsonProperty(value = PropertyNameConstants.MYSQL_OFFSET)
	    public Integer getOffset() {
	        return offset;
	    }

//	    @Override		// TODO::Check this error 
	    public MysqlSink newOperator() {
	        return new MysqlSink(this);
	    }
}
