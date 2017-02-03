package com.weijuju.iag.midea.gohome.dataobject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andShareIdIsNull() {
            addCriterion("share_id is null");
            return (Criteria) this;
        }

        public Criteria andShareIdIsNotNull() {
            addCriterion("share_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareIdEqualTo(String value) {
            addCriterion("share_id =", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotEqualTo(String value) {
            addCriterion("share_id <>", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThan(String value) {
            addCriterion("share_id >", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdGreaterThanOrEqualTo(String value) {
            addCriterion("share_id >=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThan(String value) {
            addCriterion("share_id <", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLessThanOrEqualTo(String value) {
            addCriterion("share_id <=", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdLike(String value) {
            addCriterion("share_id like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotLike(String value) {
            addCriterion("share_id not like", value, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdIn(List<String> values) {
            addCriterion("share_id in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotIn(List<String> values) {
            addCriterion("share_id not in", values, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdBetween(String value1, String value2) {
            addCriterion("share_id between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andShareIdNotBetween(String value1, String value2) {
            addCriterion("share_id not between", value1, value2, "shareId");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUserWeixinIsNull() {
            addCriterion("user_weixin is null");
            return (Criteria) this;
        }

        public Criteria andUserWeixinIsNotNull() {
            addCriterion("user_weixin is not null");
            return (Criteria) this;
        }

        public Criteria andUserWeixinEqualTo(Boolean value) {
            addCriterion("user_weixin =", value, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinNotEqualTo(Boolean value) {
            addCriterion("user_weixin <>", value, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinGreaterThan(Boolean value) {
            addCriterion("user_weixin >", value, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinGreaterThanOrEqualTo(Boolean value) {
            addCriterion("user_weixin >=", value, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinLessThan(Boolean value) {
            addCriterion("user_weixin <", value, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinLessThanOrEqualTo(Boolean value) {
            addCriterion("user_weixin <=", value, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinIn(List<Boolean> values) {
            addCriterion("user_weixin in", values, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinNotIn(List<Boolean> values) {
            addCriterion("user_weixin not in", values, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinBetween(Boolean value1, Boolean value2) {
            addCriterion("user_weixin between", value1, value2, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andUserWeixinNotBetween(Boolean value1, Boolean value2) {
            addCriterion("user_weixin not between", value1, value2, "userWeixin");
            return (Criteria) this;
        }

        public Criteria andStartCityIsNull() {
            addCriterion("start_city is null");
            return (Criteria) this;
        }

        public Criteria andStartCityIsNotNull() {
            addCriterion("start_city is not null");
            return (Criteria) this;
        }

        public Criteria andStartCityEqualTo(String value) {
            addCriterion("start_city =", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotEqualTo(String value) {
            addCriterion("start_city <>", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityGreaterThan(String value) {
            addCriterion("start_city >", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityGreaterThanOrEqualTo(String value) {
            addCriterion("start_city >=", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLessThan(String value) {
            addCriterion("start_city <", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLessThanOrEqualTo(String value) {
            addCriterion("start_city <=", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityLike(String value) {
            addCriterion("start_city like", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotLike(String value) {
            addCriterion("start_city not like", value, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityIn(List<String> values) {
            addCriterion("start_city in", values, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotIn(List<String> values) {
            addCriterion("start_city not in", values, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityBetween(String value1, String value2) {
            addCriterion("start_city between", value1, value2, "startCity");
            return (Criteria) this;
        }

        public Criteria andStartCityNotBetween(String value1, String value2) {
            addCriterion("start_city not between", value1, value2, "startCity");
            return (Criteria) this;
        }

        public Criteria andEndCityIsNull() {
            addCriterion("end_city is null");
            return (Criteria) this;
        }

        public Criteria andEndCityIsNotNull() {
            addCriterion("end_city is not null");
            return (Criteria) this;
        }

        public Criteria andEndCityEqualTo(String value) {
            addCriterion("end_city =", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotEqualTo(String value) {
            addCriterion("end_city <>", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityGreaterThan(String value) {
            addCriterion("end_city >", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityGreaterThanOrEqualTo(String value) {
            addCriterion("end_city >=", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLessThan(String value) {
            addCriterion("end_city <", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLessThanOrEqualTo(String value) {
            addCriterion("end_city <=", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityLike(String value) {
            addCriterion("end_city like", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotLike(String value) {
            addCriterion("end_city not like", value, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityIn(List<String> values) {
            addCriterion("end_city in", values, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotIn(List<String> values) {
            addCriterion("end_city not in", values, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityBetween(String value1, String value2) {
            addCriterion("end_city between", value1, value2, "endCity");
            return (Criteria) this;
        }

        public Criteria andEndCityNotBetween(String value1, String value2) {
            addCriterion("end_city not between", value1, value2, "endCity");
            return (Criteria) this;
        }

        public Criteria andStartCityTempIsNull() {
            addCriterion("start_city_temp is null");
            return (Criteria) this;
        }

        public Criteria andStartCityTempIsNotNull() {
            addCriterion("start_city_temp is not null");
            return (Criteria) this;
        }

        public Criteria andStartCityTempEqualTo(Integer value) {
            addCriterion("start_city_temp =", value, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempNotEqualTo(Integer value) {
            addCriterion("start_city_temp <>", value, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempGreaterThan(Integer value) {
            addCriterion("start_city_temp >", value, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_city_temp >=", value, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempLessThan(Integer value) {
            addCriterion("start_city_temp <", value, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempLessThanOrEqualTo(Integer value) {
            addCriterion("start_city_temp <=", value, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempIn(List<Integer> values) {
            addCriterion("start_city_temp in", values, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempNotIn(List<Integer> values) {
            addCriterion("start_city_temp not in", values, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempBetween(Integer value1, Integer value2) {
            addCriterion("start_city_temp between", value1, value2, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andStartCityTempNotBetween(Integer value1, Integer value2) {
            addCriterion("start_city_temp not between", value1, value2, "startCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempIsNull() {
            addCriterion("end_city_temp is null");
            return (Criteria) this;
        }

        public Criteria andEndCityTempIsNotNull() {
            addCriterion("end_city_temp is not null");
            return (Criteria) this;
        }

        public Criteria andEndCityTempEqualTo(Integer value) {
            addCriterion("end_city_temp =", value, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempNotEqualTo(Integer value) {
            addCriterion("end_city_temp <>", value, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempGreaterThan(Integer value) {
            addCriterion("end_city_temp >", value, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_city_temp >=", value, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempLessThan(Integer value) {
            addCriterion("end_city_temp <", value, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempLessThanOrEqualTo(Integer value) {
            addCriterion("end_city_temp <=", value, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempIn(List<Integer> values) {
            addCriterion("end_city_temp in", values, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempNotIn(List<Integer> values) {
            addCriterion("end_city_temp not in", values, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempBetween(Integer value1, Integer value2) {
            addCriterion("end_city_temp between", value1, value2, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andEndCityTempNotBetween(Integer value1, Integer value2) {
            addCriterion("end_city_temp not between", value1, value2, "endCityTemp");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Integer value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Integer value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Integer value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Integer value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Integer value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Integer> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Integer> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Integer value1, Integer value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeIsNull() {
            addCriterion("luckdrawtime is null");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeIsNotNull() {
            addCriterion("luckdrawtime is not null");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeEqualTo(Date value) {
            addCriterion("luckdrawtime =", value, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeNotEqualTo(Date value) {
            addCriterion("luckdrawtime <>", value, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeGreaterThan(Date value) {
            addCriterion("luckdrawtime >", value, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("luckdrawtime >=", value, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeLessThan(Date value) {
            addCriterion("luckdrawtime <", value, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeLessThanOrEqualTo(Date value) {
            addCriterion("luckdrawtime <=", value, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeIn(List<Date> values) {
            addCriterion("luckdrawtime in", values, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeNotIn(List<Date> values) {
            addCriterion("luckdrawtime not in", values, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeBetween(Date value1, Date value2) {
            addCriterion("luckdrawtime between", value1, value2, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawtimeNotBetween(Date value1, Date value2) {
            addCriterion("luckdrawtime not between", value1, value2, "luckdrawtime");
            return (Criteria) this;
        }

        public Criteria andLuckdrawIsNull() {
            addCriterion("luckdraw is null");
            return (Criteria) this;
        }

        public Criteria andLuckdrawIsNotNull() {
            addCriterion("luckdraw is not null");
            return (Criteria) this;
        }

        public Criteria andLuckdrawEqualTo(Boolean value) {
            addCriterion("luckdraw =", value, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawNotEqualTo(Boolean value) {
            addCriterion("luckdraw <>", value, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawGreaterThan(Boolean value) {
            addCriterion("luckdraw >", value, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawGreaterThanOrEqualTo(Boolean value) {
            addCriterion("luckdraw >=", value, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawLessThan(Boolean value) {
            addCriterion("luckdraw <", value, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawLessThanOrEqualTo(Boolean value) {
            addCriterion("luckdraw <=", value, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawIn(List<Boolean> values) {
            addCriterion("luckdraw in", values, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawNotIn(List<Boolean> values) {
            addCriterion("luckdraw not in", values, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawBetween(Boolean value1, Boolean value2) {
            addCriterion("luckdraw between", value1, value2, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andLuckdrawNotBetween(Boolean value1, Boolean value2) {
            addCriterion("luckdraw not between", value1, value2, "luckdraw");
            return (Criteria) this;
        }

        public Criteria andWinningIsNull() {
            addCriterion("winning is null");
            return (Criteria) this;
        }

        public Criteria andWinningIsNotNull() {
            addCriterion("winning is not null");
            return (Criteria) this;
        }

        public Criteria andWinningEqualTo(Boolean value) {
            addCriterion("winning =", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningNotEqualTo(Boolean value) {
            addCriterion("winning <>", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningGreaterThan(Boolean value) {
            addCriterion("winning >", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningGreaterThanOrEqualTo(Boolean value) {
            addCriterion("winning >=", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningLessThan(Boolean value) {
            addCriterion("winning <", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningLessThanOrEqualTo(Boolean value) {
            addCriterion("winning <=", value, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningIn(List<Boolean> values) {
            addCriterion("winning in", values, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningNotIn(List<Boolean> values) {
            addCriterion("winning not in", values, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningBetween(Boolean value1, Boolean value2) {
            addCriterion("winning between", value1, value2, "winning");
            return (Criteria) this;
        }

        public Criteria andWinningNotBetween(Boolean value1, Boolean value2) {
            addCriterion("winning not between", value1, value2, "winning");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNull() {
            addCriterion("headImage is null");
            return (Criteria) this;
        }

        public Criteria andHeadimageIsNotNull() {
            addCriterion("headImage is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimageEqualTo(String value) {
            addCriterion("headImage =", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotEqualTo(String value) {
            addCriterion("headImage <>", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThan(String value) {
            addCriterion("headImage >", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageGreaterThanOrEqualTo(String value) {
            addCriterion("headImage >=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThan(String value) {
            addCriterion("headImage <", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLessThanOrEqualTo(String value) {
            addCriterion("headImage <=", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageLike(String value) {
            addCriterion("headImage like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotLike(String value) {
            addCriterion("headImage not like", value, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageIn(List<String> values) {
            addCriterion("headImage in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotIn(List<String> values) {
            addCriterion("headImage not in", values, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageBetween(String value1, String value2) {
            addCriterion("headImage between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andHeadimageNotBetween(String value1, String value2) {
            addCriterion("headImage not between", value1, value2, "headimage");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNull() {
            addCriterion("prize_type is null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIsNotNull() {
            addCriterion("prize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeEqualTo(String value) {
            addCriterion("prize_type =", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotEqualTo(String value) {
            addCriterion("prize_type <>", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThan(String value) {
            addCriterion("prize_type >", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("prize_type >=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThan(String value) {
            addCriterion("prize_type <", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLessThanOrEqualTo(String value) {
            addCriterion("prize_type <=", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeLike(String value) {
            addCriterion("prize_type like", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotLike(String value) {
            addCriterion("prize_type not like", value, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeIn(List<String> values) {
            addCriterion("prize_type in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotIn(List<String> values) {
            addCriterion("prize_type not in", values, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeBetween(String value1, String value2) {
            addCriterion("prize_type between", value1, value2, "prizeType");
            return (Criteria) this;
        }

        public Criteria andPrizeTypeNotBetween(String value1, String value2) {
            addCriterion("prize_type not between", value1, value2, "prizeType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}