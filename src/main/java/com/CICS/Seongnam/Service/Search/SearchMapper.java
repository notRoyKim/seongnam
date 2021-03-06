package com.CICS.Seongnam.Service.Search;

import com.CICS.Seongnam.Domain.Search_Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;

@Mapper
public interface SearchMapper {
    //전체 검색
    @Select("SELECT Data_Info.No FROM `Data_Info` JOIN Gusul_Info WHERE Data_Info.Name_No = Gusul_Info.Name_No AND (Gusul_Info.Name LIKE '%${SearchWord}%' OR Data_Info.Title LIKE '%${SearchWord}%' OR Data_Info.Data_Background LIKE '%${SearchWord}%' OR Data_Info.Contents LIKE '%${SearchWord}%') ORDER BY Data_Info.No DESC")
    List<String> getSearchResultNo(String SearchWord);

    //리미트를 가진 검색
    @Select("SELECT Data_Info.No FROM `Data_Info` JOIN Gusul_Info WHERE Data_Info.Name_No = Gusul_Info.Name_No AND (Gusul_Info.Name LIKE '%${SearchWord}%' OR Data_Info.Title LIKE '%${SearchWord}%' OR Data_Info.Data_Background LIKE '%${SearchWord}%' OR Data_Info.Contents LIKE '%${SearchWord}%') ORDER BY Data_Info.No DESC LIMIT ${Page}, ${NumPage}")
    List<String> getSearchResultNoByLimit(String SearchWord, int Page, int NumPage);

    @Select("SELECT * FROM SearchResultView WHERE No = '${No}' ORDER BY No;")
    Search_Result getSearchResultByNo(String No);
}
