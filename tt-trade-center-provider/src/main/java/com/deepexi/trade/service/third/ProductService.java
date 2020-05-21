package com.deepexi.trade.service.third;


import com.deepexi.product.domain.eo.Product;
import com.deepexi.trade.adapter.Sku;
import com.deepexi.trade.domain.dto.SkuInfo;
import com.deepexi.trade.service.third.domain.*;

import java.util.List;
import java.util.Map;

/**
 *   @author JiaMing  2019/5/17.
 */
public interface ProductService {

    /**
     * 创建商品（草稿、待审核）
     *
     * @param dto 数据
     * @return Boolean
     */
//    Boolean create(ProductCreateDto dto);

    /**
     * 编辑商品
     *
     * @param pk  主键ID
     * @param dto 数据
     * @return Boolean
     */
//    Boolean update(String pk, ProductCreateDto dto);

    /**
     * 删除商品  (草稿及驳回状态才能删除)
     *
     * @param pkList 主键ID列表
     * @return Boolean
     */
    Boolean delete(List<String> pkList);

    /**
     * 后台购券管理列表分页
     *
     * @param queryDto 查询DTO
     * @param page     页码
     * @param size     页大小
     * @return PageBean
     */
//    PageBean<ProductSku> findPage(ProductQueryDto queryDto, Integer page, Integer size);

    /**
     * 后台购券管理列表分页
     *
     * @param queryDto 查询DTO
     * @param page     页码
     * @param size     页大小
     * @return PageBean
     */
//    PageBean<ProductListPageDto> findPageWithTrans(ProductQueryDto queryDto, Integer page, Integer size);

    /**
     * 查找商品列表（关联前端类目的查询）
     *
     * @param frontCategoryId 前端类目ID
     * @param fuzzyName       商品名称-模糊搜索
     * @param page            页码
     * @param size            页大小
     * @return PageBean
     */
//    PageBean<ProductInfoDto> findPageConnectFrontCategory(String frontCategoryId, String fuzzyName, Integer page, Integer size);

    /**
     * 将商品EO转换为ProductInfoDto
     *
     * @param productSkuList EO数据列表
     * @return List<ProductInfoDto>
     */
//    List<ProductInfoDto> transEoToInfoDto(List<ProductSku> productSkuList);

    /**
     * 商品详情
     *
     * @param pk 主键ID
     * @return ProductDetailDto
     */
//    ProductDetailDto detail(String pk);

    /**
     * 获取商品相关全部信息
     *
     * @param pk 主键ID
     * @return ProductAllInfoDto
     */
    ProductAllInfoDto getAllInfo(String pk);

    List<Sku> getSkus(List<SkuInfo> skuInfos);

    /**
     * 商品上架
     *
     * @return Integer 影响行数
     */
    Integer onShelf();

    /**
     * 商品下架-定时下架
     *
     * @return Integer 影响行数
     */
    Integer offShelf();

    /**
     * 商品下架
     *
     * @param productId 商品ID
     * @return Boolean
     */
    Boolean offShelf(String productId);

    /**
     * 商品审核
     *
     * @param productSkuId 商品skuID
     * @param auditDto     审核DTO
     * @return Boolean
     */
//    Boolean audit(String productSkuId, AuditDto auditDto);

    /**
     * 搜索列表
     *
     * @param name       名称
     * @param itemTagIds 标签ID列表
     * @param sortType   排序类型
     * @param sortAsc    排序升降
     * @param page       页码
     * @param size       页大小
     * @return List
     */
//    PageBean<ProductSearchResultDto> search(String name, List<String> itemTagIds, Integer sortType, Integer sortAsc, Integer page, Integer size);

    /**
     * 分页查询（渠道端使用）
     *
     * @param stockFilter 库存过滤-库存为0的商品不展示（0-否，1-是）
     * @param page        页码
     * @param size        页大小
     * @return PageBean
     */
//    PageBean<ProductSearchResultDto> findPageToChannel(Integer stockFilter, Integer page, Integer size);

    /**
     * 前端类目
     *
     * @param frontCategoryId 前端类目ID
     * @param page            页码
     * @param size            页大小
     * @return PageBean
     */
//    PageBean<ProductSearchResultDto> searchByFrontCategoryId(String frontCategoryId, Integer page, Integer size);

    /**
     * 根据ID列表获取对应商品信息
     *
     * @param pkList   主键ID列表
     * @param sortType 排序类型
     * @return List
     */
//    List<ProductSearchResultDto> searchByIdList(List<String> pkList, Integer sortType);

    /**
     * 冻结库存
     *
     * @param pk  主键ID
     * @param num 数量
     * @return Boolean
     */
    Boolean frozen(String pk, Integer num);

    /**
     * 冻结库存-批量操作
     *
     * @param dtoList ID-数量DTO列表
     * @return Boolean
     */
    Boolean frozenBatch(List<IdNumDto> dtoList);

    /**
     * 释放已冻结库存
     *
     * @param pk  主键ID
     * @param num 数量
     * @return Boolean
     */
    Boolean releaseFrozen(String pk, Integer num);

    /**
     * 释放已冻结库存-批量操作
     *
     * @param dtoList ID-数量DTO列表
     * @return Boolean
     */
    Boolean releaseFrozenBatch(List<IdNumDto> dtoList);

    /**
     * 占用库存（将冻结库存转为占用库存）
     *
     * @param pk  主键ID
     * @param num 数量
     * @return Boolean
     */
    Boolean occupyFromFrozen(String pk, Integer num);

    /**
     * 占用库存（将冻结库存转为占用库存）-批量操作
     *
     * @param dtoList ID-数量DTO列表
     * @return Boolean
     */
    Boolean occupyFromFrozenBatch(List<IdNumDto> dtoList);

    /**
     * 返还剩余库存（增加剩余库存）
     *
     * @param pk  主键ID
     * @param num 数量
     * @return Boolean
     */
    Boolean addRemainStock(String pk, Integer num);

    /**
     * 返还剩余库存（增加剩余库存）-批量操作
     *
     * @param dtoList ID-数量DTO列表
     * @return Boolean
     */
    Boolean addRemainStockBatch(List<IdNumDto> dtoList);

    Product selectById(String pk, boolean throwFlag);
}
