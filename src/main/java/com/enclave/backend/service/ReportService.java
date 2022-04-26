package com.enclave.backend.service;

import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

public interface ReportService {

    List<Object[]> getTopSeller(short branchId,String date, String type);

    List<Object[]> getTopSellerDaily(short branchId,String date);

    List<Object[]> getBestSellingAllCategory(short branchId, String date, String type);

    List<Object[]> getBestSellingAllCategoryDaily(short branchId, String date);

    List<Object[]> getBestSellingByCategory(short branchId, short categoryId, String date, String type);

    List<Object[]> getBestSellingByCategoryDaily(short branchId, short categoryId, String date);


    //OWNER REPORT
    //revenue
    List<Object[]> getRevenueAllBranchByTime(String date, String type);

    //allCategory
    List<Object[]> getProductAllCategoryByTime(String date, String type);

    //eachCategory
    List<Object[]> getProductEachCategoryByTime(short categoryId, String date, String type);
}