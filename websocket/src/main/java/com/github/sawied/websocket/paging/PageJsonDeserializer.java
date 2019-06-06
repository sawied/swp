package com.github.sawied.websocket.paging;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonComponent
public class PageJsonDeserializer extends JsonDeserializer<Page<?>>{

	@Override
	public Page<?> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		TreeNode treeNode=p.readValueAsTree();
		ObjectMapper objectMapper=(ObjectMapper) p.getCodec();
		JavaType jt=ctxt.getContextualType();
		TreeNode contentNode = treeNode.get("content");
		
		Class<?> type = this.handledType();
		
		if(contentNode.isArray()) {
			int size=contentNode.size();
			for(int i =0 ; i<size;i++) {
				TreeNode contentObjectNode = contentNode.get(i);
				//objectMapper.
			}
		}
		
		return null;
	}
	
	

}
