package com.v5ent.rest;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.internal.inject.Custom;


@Path("")
public class AppRestService {
	//Read JSON file with UTF-8
	private String readJson(String file){
		File f = new File(this.getClass().getResource("").getPath()+"\\json\\"+file); 
    	String result = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(  
	                new FileInputStream(f), "UTF-8"));  
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				result+=new String(tempString);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return result;
	}

	@GET
    public String index() {
        return readJson("index.html");
    }
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("goods")
    public String getGoodsMaster() {
        return readJson("getGoodsMaster.json");//1.App商品列表
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categoties")
    public String getCategotyies() {
    	return readJson("getGcMasterList.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("brands")
    public String getBrands() {
    	return readJson("getBrandList.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("goods/{goodsid}")
    public String getGoodsById(@PathParam("goodsid")String goodsid) {
        return readJson("getGoodsMasterById.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("shop/introduce")
    public String getShopById(@PathParam("id")String id) {
    	return readJson("getShopById.json");
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("shop/introduce")
    public String updateShopById(String introduce) {
    	return readJson("通用成功.json");
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("goods/{goodsid}")
    public String deleteGoodsById(@PathParam("goodsid")String goodsid) {
    	return readJson("4.商品删除接口.json");//goodsIds
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("freightfee")
    public String cumputeFreight() {
    	return readJson("5.获取订单运费.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("order")
    public String queryOrderList(@QueryParam("shopId") String shopId,
    		@QueryParam("page")int page,@QueryParam("pageCount")int pageCount,@QueryParam("type") int type) {
    	return readJson("7.订单列表查询.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("queryOrder")
    public String queryOrderListForBack(@QueryParam("shopId") String shopId,
    		@QueryParam("page")int page,@QueryParam("pageCount")int pageCount) {
    	return readJson("queryOrder.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("orderDetail")
    public String queryOrderDetailList(@PathParam("soNo") String soNo) {
    	return readJson("8.订单详情查询.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("order/{soNo}")
    public String queryOrderDetail(@PathParam("soNo") String soNo) {
    	return readJson("单个订单详情.json");
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("order/{soNo}")
    public String deleteOrdersById(@PathParam("soNo") String soNo) {
    	return readJson("9.订单删除接口.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("messages")
    public String getMessages(@QueryParam("recieverId")String recieverId,@QueryParam("page")int page,@QueryParam("pageCount")int pageCount) {
    	return readJson("11.获取消息.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("messages/unread")
    public String getUnreadMessages(@QueryParam("recieverId")String recieverId) {
    	return "{\"code\":0, \"data\":3, \"error\":false, \"status\":\"OK\", \"success\":true}";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("messages/{id}")
    public String readMessage(@PathParam("id") String id) {
    	return readJson("12.修改消息状态接口.json");
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("messages/{id}")
    public String removeMessage(@PathParam("id") String id) {
    	return readJson("12.删除消息.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user/{crmid}")
    public String getUserById(@PathParam("crmid")String crmid) {
    	return readJson("getUserInfo.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("verifycode")
    public String getVerifyCode(@QueryParam("phoneno") String phoneno) {
    	return readJson("getVerifyCode.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("register")
    public String register(String loginCodepassWord) {
    	return readJson("userRegister.json");//注册
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public String login(String loginCodepassWord) {
    	return readJson("userLogin.json");//登录
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("avatar/{crmId}")
    public String updateAvatarByCrmid(@PathParam("crmId")String crmId,@QueryParam("avatarPath")String avatarPath) {
    	return readJson("updateAvatarByCrmid.json");//用户上传头像接口(图片返回之后调用)
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address")
    public String getUserAddress(@QueryParam("crmId")String crmId) {
    	return readJson("getAddressListByCrmid.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("areaProvinceId")
    public String areaProvinceId() {
    	return readJson("areaProvinceId.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("areaChildren")
    public String areaChildren(@QueryParam("areaId")String areaId) {
    	return readJson("areaChildren.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address")
    public String addNewAddresOrUpdateAddress(String addressObject) {
    	return readJson("addNewAddresOrUpdateAddress.json");//16.增加、修改用户地址
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address/{addressid}")
    public String deleteAddress() {
    	return readJson("deleteAddress.json");//17.删除地址
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("shopcart")
    public String getShopcart(@QueryParam("accountId")String accountId) {
    	return readJson("18.获取购物车商品列表.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addShopCart")
    public String addShopcart(String shopIdgoodIdaccountId	) {
    	return readJson("19.添加商品到购物车.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("removeShopCart")
    public String removeShopcart(String shopIdgoodIdaccountId) {
    	return readJson("20.删除购物车商品.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("shopusers/{ownerId}")
    public String getShopUserByCrmid(@PathParam("ownerId")String ownerId) {
    	return readJson("getShopUserByCrmid.json");//获取店铺用户列表
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("shelfupdown")
    public String itemUpshelf(String goodsidshopid) {
    	return readJson("4.商品删除接口.json");//商品上下架
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("useOrderQty")
    public String useOrderQty(@QueryParam("shopid")String shopid) {
    	return readJson("useOrderQty.json");//订单量数据查询
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("useQty")
    public String useQty(@QueryParam("crmId")String crmId) {
    	return readJson("useQty.json");//曲线图用户量
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("orderIncome")
    public String orderIncome(@QueryParam("shopid")String shopid) {
    	return readJson("orderIncome.json");//店铺订单收入列表查询
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("incomeData")
    public String incomeData(@QueryParam("shopid")String shopid) {
    	return readJson("incomeData.json");//曲线图收入数据查询
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getModelList")
    public String getModelList(@QueryParam("bandId")String bandId,@QueryParam("categoryId")String categoryId) {
    	return readJson("getModelList.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getShopcartGoodsCount")
    public String getShopcartGoodsCount(@QueryParam("accountid")String accountid) {
    	return readJson("getShopcartGoodsCount.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("calcFreight")
    public String calcFreight(@QueryParam("goodsid")String goodsid,@QueryParam("amount")String amount) {
    	return readJson("calcFreight.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("editGoods")
    public String editGoods(String goodsMasterObj) {
    	return readJson("editGoods.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("goodseditlist")
    public String goodseditlist(@QueryParam("shopId")String shopId) {
    	return readJson("goodseditlist.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("queryToReceive")
    public String queryToReceive(@QueryParam("customerId")String customerId) {
    	return readJson("queryToReceive.json");
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("queryToPay")
    public String queryToPay(@QueryParam("customerId")String customerId) {
    	return readJson("queryToPay.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("insertGoodsMasterList")
    public String insertGoodsMasterList(String goodsMasterObj) {
    	return readJson("insertGoodsMasterList.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("updateOnSaleApply")
    public String updateOnSaleApply(String onSaleApplyVOonSaleGoodsList) {
    	return readJson("updateOnSaleApply.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addOnSaleApply")
    public String addOnSaleApply(String onSaleApplyVOonSaleGoodsList) {
    	return readJson("addOnSaleApply.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("manageCurrentPromotion")
    public String manageCurrentPromotion(String applyIdshopIdtodo) {
    	return readJson("manageCurrentPromotion.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("onSaleApplies")
    public String onSaleApplies(String applyIdshopIdtodo) {
    	return readJson("getOnSaleApplies.json");//App首页活动
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("submitOrder")
    public String submitOrder(String order) {
    	return readJson("submitOrder.json");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("preSettlement")
    public String preSettlement(String order) {
    	return readJson("preSettlement.json");
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("confirmReceipt")
    public String confirmReceipt(String sono) {
    	return readJson("confirmReceipt.json");//confirmReceipt
    }
    
}
