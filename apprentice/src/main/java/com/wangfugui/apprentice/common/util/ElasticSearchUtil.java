package com.wangfugui.apprentice.common.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/11/25
 * @since JDK 1.8.0
 */
@Component
@Slf4j
public class ElasticSearchUtil {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    /**
     * ???????????????
     *
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/11/27
     */
    public CreateIndexResponse createIndex(String index) throws IOException {
        //1.?????????????????????
        CreateIndexRequest request = new CreateIndexRequest(index);
        //2?????????????????????????????????????????????
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        log.info("???????????????{}", response);
        return response;
    }

    /**
     * ??????????????????
     */
    public Boolean existIndex(String index) throws IOException {
        //1.?????????????????????
        GetIndexRequest request = new GetIndexRequest(index);
        //2?????????????????????????????????????????????
        boolean exist = client.indices().exists(request, RequestOptions.DEFAULT);
        log.info("??????????????????-----" + exist);
        return exist;
    }

    /**
     * ????????????
     */
    public Boolean deleteIndex(String index) throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(index);
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        log.info("????????????--------" + delete.isAcknowledged());
        return delete.isAcknowledged();
    }

    /**
     * ????????????
     */
    public IndexResponse addDocument(Object object, String index) throws IOException {
        IndexRequest request = new IndexRequest(index);
        //??????????????????
        request.timeout("1s");
        //???????????????json?????????
        request.source(JSON.toJSONString(object), XContentType.JSON);
        //????????????
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        log.info("????????????-------" + response.toString());
        log.info("????????????-------" + response.status());
        return response;
    }

    /**
     * ??????????????????
     */
    public Boolean existDocument(String index, String documents) throws IOException {
        //????????? ??????index
        GetRequest request = new GetRequest(index, documents);
        //??????indices()???
        boolean exist = client.exists(request, RequestOptions.DEFAULT);
        log.info("??????????????????-----" + exist);
        return exist;
    }

    /**
     * ????????????
     */
    public GetResponse getDocument(String index, String documents) throws IOException {
        GetRequest request = new GetRequest(index, documents);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        log.info("????????????-----" + response.getSourceAsString());
        log.info("????????????-----" + response);
        return response;
    }

    /**
     * ????????????
     */
    public UpdateResponse updateDocument(Object object, String index, String documents) throws IOException {

        //?????????id???1???
        UpdateRequest request = new UpdateRequest(index, documents);
        request.timeout("1s");
        request.doc(JSON.toJSONString(object), XContentType.JSON);

        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        log.info("????????????-----" + response);
        log.info("????????????-----" + response.status());

        return response;
    }


    /**
     * ????????????
     */
    public RestStatus deleteDocument(String index, String documents) throws IOException {
        DeleteRequest request = new DeleteRequest(index, documents);
        request.timeout("1s");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        log.info("????????????------" + response.status());
        return response.status();
    }

    /**
     * ??????????????????
     */
    public BulkResponse bulkAddDocument(List<?> object) throws IOException {

        //???????????????Request
        BulkRequest request = new BulkRequest();
        request.timeout("1s");

        //??????????????????
        for (int i = 0; i < object.size(); i++) {
            request.add(
                    new IndexRequest("lisen_index")
                            .id("" + (i + 1))
                            .source(JSON.toJSONString(object.get(i)), XContentType.JSON)
            );
        }
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        //response.hasFailures()??????????????????
        log.info("??????????????????-----" + response.hasFailures());

//        ??????:false????????? true?????????
        return response;
    }


    /**
     * ????????????
     */
    public SearchResponse searchDocument(String index) throws IOException {
        SearchRequest request = new SearchRequest(index);
        //??????????????????
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //???????????????
        sourceBuilder.highlighter();
        //term name???cyx1???
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "cyx1");
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        log.info("????????????-----" + JSON.toJSONString(response.getHits()));
        log.info("=====================");
        for (SearchHit documentFields : response.getHits().getHits()) {
            log.info("????????????--????????????--" + documentFields.getSourceAsMap());
        }
        return response;
    }

    /**
     * ?????????????????????id
     */
    public IndexResponse addDocumentId(Object object, String index, String id) throws IOException {

        IndexRequest request = new IndexRequest(index);
        //??????????????????
        request.id(id);
        //???????????????json?????????
        request.source(JSON.toJSONString(object), XContentType.JSON);
        //????????????
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        log.info("????????????-------" + response.toString());
        log.info("????????????-------" + response.status());
        return response;
    }

    /**
     * ?????????????????????
     *
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/11/27
     */
    public IndexResponse addEntity(Object object, String index, String id) throws IOException {
        boolean existIndex = this.existIndex(index);
        if (!existIndex) {
            createIndex(index);

        }
        return addDocumentId(object, index, id);
    }

    /**
     * ?????????????????????
     *
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/11/27
     */
    public IndexResponse addEntity(Object object, String index) throws IOException {
        boolean existIndex = this.existIndex(index);
        if (!existIndex) {
            createIndex(index);

        }
        return addDocument(object, index);
    }


    public SearchResponse search(String searchMatch, String searchStr) throws IOException {
        SearchRequest request = new SearchRequest();
        //??????????????????
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        QueryBuilder queryBuilder = new MatchQueryBuilder(searchMatch, searchStr);
        sourceBuilder.query(queryBuilder);
        request.source(sourceBuilder);
        return client.search(request, RequestOptions.DEFAULT);

    }
}
