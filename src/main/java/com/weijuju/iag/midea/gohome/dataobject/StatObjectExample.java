package com.weijuju.iag.midea.gohome.dataobject;

import java.util.ArrayList;
import java.util.List;

public class StatObjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StatObjectExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStatDateIsNull() {
            addCriterion("stat_date is null");
            return (Criteria) this;
        }

        public Criteria andStatDateIsNotNull() {
            addCriterion("stat_date is not null");
            return (Criteria) this;
        }

        public Criteria andStatDateEqualTo(String value) {
            addCriterion("stat_date =", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotEqualTo(String value) {
            addCriterion("stat_date <>", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThan(String value) {
            addCriterion("stat_date >", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThanOrEqualTo(String value) {
            addCriterion("stat_date >=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThan(String value) {
            addCriterion("stat_date <", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThanOrEqualTo(String value) {
            addCriterion("stat_date <=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLike(String value) {
            addCriterion("stat_date like", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotLike(String value) {
            addCriterion("stat_date not like", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateIn(List<String> values) {
            addCriterion("stat_date in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotIn(List<String> values) {
            addCriterion("stat_date not in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateBetween(String value1, String value2) {
            addCriterion("stat_date between", value1, value2, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotBetween(String value1, String value2) {
            addCriterion("stat_date not between", value1, value2, "statDate");
            return (Criteria) this;
        }

        public Criteria andPvIsNull() {
            addCriterion("pv is null");
            return (Criteria) this;
        }

        public Criteria andPvIsNotNull() {
            addCriterion("pv is not null");
            return (Criteria) this;
        }

        public Criteria andPvEqualTo(Integer value) {
            addCriterion("pv =", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotEqualTo(Integer value) {
            addCriterion("pv <>", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvGreaterThan(Integer value) {
            addCriterion("pv >", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvGreaterThanOrEqualTo(Integer value) {
            addCriterion("pv >=", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvLessThan(Integer value) {
            addCriterion("pv <", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvLessThanOrEqualTo(Integer value) {
            addCriterion("pv <=", value, "pv");
            return (Criteria) this;
        }

        public Criteria andPvIn(List<Integer> values) {
            addCriterion("pv in", values, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotIn(List<Integer> values) {
            addCriterion("pv not in", values, "pv");
            return (Criteria) this;
        }

        public Criteria andPvBetween(Integer value1, Integer value2) {
            addCriterion("pv between", value1, value2, "pv");
            return (Criteria) this;
        }

        public Criteria andPvNotBetween(Integer value1, Integer value2) {
            addCriterion("pv not between", value1, value2, "pv");
            return (Criteria) this;
        }

        public Criteria andUvIsNull() {
            addCriterion("uv is null");
            return (Criteria) this;
        }

        public Criteria andUvIsNotNull() {
            addCriterion("uv is not null");
            return (Criteria) this;
        }

        public Criteria andUvEqualTo(Integer value) {
            addCriterion("uv =", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvNotEqualTo(Integer value) {
            addCriterion("uv <>", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvGreaterThan(Integer value) {
            addCriterion("uv >", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvGreaterThanOrEqualTo(Integer value) {
            addCriterion("uv >=", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvLessThan(Integer value) {
            addCriterion("uv <", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvLessThanOrEqualTo(Integer value) {
            addCriterion("uv <=", value, "uv");
            return (Criteria) this;
        }

        public Criteria andUvIn(List<Integer> values) {
            addCriterion("uv in", values, "uv");
            return (Criteria) this;
        }

        public Criteria andUvNotIn(List<Integer> values) {
            addCriterion("uv not in", values, "uv");
            return (Criteria) this;
        }

        public Criteria andUvBetween(Integer value1, Integer value2) {
            addCriterion("uv between", value1, value2, "uv");
            return (Criteria) this;
        }

        public Criteria andUvNotBetween(Integer value1, Integer value2) {
            addCriterion("uv not between", value1, value2, "uv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvIsNull() {
            addCriterion("immediatelygeneratepv is null");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvIsNotNull() {
            addCriterion("immediatelygeneratepv is not null");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvEqualTo(Integer value) {
            addCriterion("immediatelygeneratepv =", value, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvNotEqualTo(Integer value) {
            addCriterion("immediatelygeneratepv <>", value, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvGreaterThan(Integer value) {
            addCriterion("immediatelygeneratepv >", value, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvGreaterThanOrEqualTo(Integer value) {
            addCriterion("immediatelygeneratepv >=", value, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvLessThan(Integer value) {
            addCriterion("immediatelygeneratepv <", value, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvLessThanOrEqualTo(Integer value) {
            addCriterion("immediatelygeneratepv <=", value, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvIn(List<Integer> values) {
            addCriterion("immediatelygeneratepv in", values, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvNotIn(List<Integer> values) {
            addCriterion("immediatelygeneratepv not in", values, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvBetween(Integer value1, Integer value2) {
            addCriterion("immediatelygeneratepv between", value1, value2, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygeneratepvNotBetween(Integer value1, Integer value2) {
            addCriterion("immediatelygeneratepv not between", value1, value2, "immediatelygeneratepv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvIsNull() {
            addCriterion("immediatelygenerateuv is null");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvIsNotNull() {
            addCriterion("immediatelygenerateuv is not null");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvEqualTo(Integer value) {
            addCriterion("immediatelygenerateuv =", value, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvNotEqualTo(Integer value) {
            addCriterion("immediatelygenerateuv <>", value, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvGreaterThan(Integer value) {
            addCriterion("immediatelygenerateuv >", value, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvGreaterThanOrEqualTo(Integer value) {
            addCriterion("immediatelygenerateuv >=", value, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvLessThan(Integer value) {
            addCriterion("immediatelygenerateuv <", value, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvLessThanOrEqualTo(Integer value) {
            addCriterion("immediatelygenerateuv <=", value, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvIn(List<Integer> values) {
            addCriterion("immediatelygenerateuv in", values, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvNotIn(List<Integer> values) {
            addCriterion("immediatelygenerateuv not in", values, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvBetween(Integer value1, Integer value2) {
            addCriterion("immediatelygenerateuv between", value1, value2, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andImmediatelygenerateuvNotBetween(Integer value1, Integer value2) {
            addCriterion("immediatelygenerateuv not between", value1, value2, "immediatelygenerateuv");
            return (Criteria) this;
        }

        public Criteria andHelppvIsNull() {
            addCriterion("helppv is null");
            return (Criteria) this;
        }

        public Criteria andHelppvIsNotNull() {
            addCriterion("helppv is not null");
            return (Criteria) this;
        }

        public Criteria andHelppvEqualTo(Integer value) {
            addCriterion("helppv =", value, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvNotEqualTo(Integer value) {
            addCriterion("helppv <>", value, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvGreaterThan(Integer value) {
            addCriterion("helppv >", value, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvGreaterThanOrEqualTo(Integer value) {
            addCriterion("helppv >=", value, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvLessThan(Integer value) {
            addCriterion("helppv <", value, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvLessThanOrEqualTo(Integer value) {
            addCriterion("helppv <=", value, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvIn(List<Integer> values) {
            addCriterion("helppv in", values, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvNotIn(List<Integer> values) {
            addCriterion("helppv not in", values, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvBetween(Integer value1, Integer value2) {
            addCriterion("helppv between", value1, value2, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelppvNotBetween(Integer value1, Integer value2) {
            addCriterion("helppv not between", value1, value2, "helppv");
            return (Criteria) this;
        }

        public Criteria andHelpuvIsNull() {
            addCriterion("helpuv is null");
            return (Criteria) this;
        }

        public Criteria andHelpuvIsNotNull() {
            addCriterion("helpuv is not null");
            return (Criteria) this;
        }

        public Criteria andHelpuvEqualTo(Integer value) {
            addCriterion("helpuv =", value, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvNotEqualTo(Integer value) {
            addCriterion("helpuv <>", value, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvGreaterThan(Integer value) {
            addCriterion("helpuv >", value, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvGreaterThanOrEqualTo(Integer value) {
            addCriterion("helpuv >=", value, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvLessThan(Integer value) {
            addCriterion("helpuv <", value, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvLessThanOrEqualTo(Integer value) {
            addCriterion("helpuv <=", value, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvIn(List<Integer> values) {
            addCriterion("helpuv in", values, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvNotIn(List<Integer> values) {
            addCriterion("helpuv not in", values, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvBetween(Integer value1, Integer value2) {
            addCriterion("helpuv between", value1, value2, "helpuv");
            return (Criteria) this;
        }

        public Criteria andHelpuvNotBetween(Integer value1, Integer value2) {
            addCriterion("helpuv not between", value1, value2, "helpuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvIsNull() {
            addCriterion("openpackagepv is null");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvIsNotNull() {
            addCriterion("openpackagepv is not null");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvEqualTo(Integer value) {
            addCriterion("openpackagepv =", value, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvNotEqualTo(Integer value) {
            addCriterion("openpackagepv <>", value, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvGreaterThan(Integer value) {
            addCriterion("openpackagepv >", value, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvGreaterThanOrEqualTo(Integer value) {
            addCriterion("openpackagepv >=", value, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvLessThan(Integer value) {
            addCriterion("openpackagepv <", value, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvLessThanOrEqualTo(Integer value) {
            addCriterion("openpackagepv <=", value, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvIn(List<Integer> values) {
            addCriterion("openpackagepv in", values, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvNotIn(List<Integer> values) {
            addCriterion("openpackagepv not in", values, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvBetween(Integer value1, Integer value2) {
            addCriterion("openpackagepv between", value1, value2, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackagepvNotBetween(Integer value1, Integer value2) {
            addCriterion("openpackagepv not between", value1, value2, "openpackagepv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvIsNull() {
            addCriterion("openpackageuv is null");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvIsNotNull() {
            addCriterion("openpackageuv is not null");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvEqualTo(Integer value) {
            addCriterion("openpackageuv =", value, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvNotEqualTo(Integer value) {
            addCriterion("openpackageuv <>", value, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvGreaterThan(Integer value) {
            addCriterion("openpackageuv >", value, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvGreaterThanOrEqualTo(Integer value) {
            addCriterion("openpackageuv >=", value, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvLessThan(Integer value) {
            addCriterion("openpackageuv <", value, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvLessThanOrEqualTo(Integer value) {
            addCriterion("openpackageuv <=", value, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvIn(List<Integer> values) {
            addCriterion("openpackageuv in", values, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvNotIn(List<Integer> values) {
            addCriterion("openpackageuv not in", values, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvBetween(Integer value1, Integer value2) {
            addCriterion("openpackageuv between", value1, value2, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andOpenpackageuvNotBetween(Integer value1, Integer value2) {
            addCriterion("openpackageuv not between", value1, value2, "openpackageuv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvIsNull() {
            addCriterion("activitysharepv is null");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvIsNotNull() {
            addCriterion("activitysharepv is not null");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvEqualTo(Integer value) {
            addCriterion("activitysharepv =", value, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvNotEqualTo(Integer value) {
            addCriterion("activitysharepv <>", value, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvGreaterThan(Integer value) {
            addCriterion("activitysharepv >", value, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvGreaterThanOrEqualTo(Integer value) {
            addCriterion("activitysharepv >=", value, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvLessThan(Integer value) {
            addCriterion("activitysharepv <", value, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvLessThanOrEqualTo(Integer value) {
            addCriterion("activitysharepv <=", value, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvIn(List<Integer> values) {
            addCriterion("activitysharepv in", values, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvNotIn(List<Integer> values) {
            addCriterion("activitysharepv not in", values, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvBetween(Integer value1, Integer value2) {
            addCriterion("activitysharepv between", value1, value2, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivitysharepvNotBetween(Integer value1, Integer value2) {
            addCriterion("activitysharepv not between", value1, value2, "activitysharepv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvIsNull() {
            addCriterion("activityshareuv is null");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvIsNotNull() {
            addCriterion("activityshareuv is not null");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvEqualTo(Integer value) {
            addCriterion("activityshareuv =", value, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvNotEqualTo(Integer value) {
            addCriterion("activityshareuv <>", value, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvGreaterThan(Integer value) {
            addCriterion("activityshareuv >", value, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvGreaterThanOrEqualTo(Integer value) {
            addCriterion("activityshareuv >=", value, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvLessThan(Integer value) {
            addCriterion("activityshareuv <", value, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvLessThanOrEqualTo(Integer value) {
            addCriterion("activityshareuv <=", value, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvIn(List<Integer> values) {
            addCriterion("activityshareuv in", values, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvNotIn(List<Integer> values) {
            addCriterion("activityshareuv not in", values, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvBetween(Integer value1, Integer value2) {
            addCriterion("activityshareuv between", value1, value2, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andActivityshareuvNotBetween(Integer value1, Integer value2) {
            addCriterion("activityshareuv not between", value1, value2, "activityshareuv");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersIsNull() {
            addCriterion("numberofwinners is null");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersIsNotNull() {
            addCriterion("numberofwinners is not null");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersEqualTo(Integer value) {
            addCriterion("numberofwinners =", value, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersNotEqualTo(Integer value) {
            addCriterion("numberofwinners <>", value, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersGreaterThan(Integer value) {
            addCriterion("numberofwinners >", value, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersGreaterThanOrEqualTo(Integer value) {
            addCriterion("numberofwinners >=", value, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersLessThan(Integer value) {
            addCriterion("numberofwinners <", value, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersLessThanOrEqualTo(Integer value) {
            addCriterion("numberofwinners <=", value, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersIn(List<Integer> values) {
            addCriterion("numberofwinners in", values, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersNotIn(List<Integer> values) {
            addCriterion("numberofwinners not in", values, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersBetween(Integer value1, Integer value2) {
            addCriterion("numberofwinners between", value1, value2, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNumberofwinnersNotBetween(Integer value1, Integer value2) {
            addCriterion("numberofwinners not between", value1, value2, "numberofwinners");
            return (Criteria) this;
        }

        public Criteria andNewuserIsNull() {
            addCriterion("newuser is null");
            return (Criteria) this;
        }

        public Criteria andNewuserIsNotNull() {
            addCriterion("newuser is not null");
            return (Criteria) this;
        }

        public Criteria andNewuserEqualTo(Integer value) {
            addCriterion("newuser =", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotEqualTo(Integer value) {
            addCriterion("newuser <>", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserGreaterThan(Integer value) {
            addCriterion("newuser >", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserGreaterThanOrEqualTo(Integer value) {
            addCriterion("newuser >=", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserLessThan(Integer value) {
            addCriterion("newuser <", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserLessThanOrEqualTo(Integer value) {
            addCriterion("newuser <=", value, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserIn(List<Integer> values) {
            addCriterion("newuser in", values, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotIn(List<Integer> values) {
            addCriterion("newuser not in", values, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserBetween(Integer value1, Integer value2) {
            addCriterion("newuser between", value1, value2, "newuser");
            return (Criteria) this;
        }

        public Criteria andNewuserNotBetween(Integer value1, Integer value2) {
            addCriterion("newuser not between", value1, value2, "newuser");
            return (Criteria) this;
        }

        public Criteria andQudaoIsNull() {
            addCriterion("qudao is null");
            return (Criteria) this;
        }

        public Criteria andQudaoIsNotNull() {
            addCriterion("qudao is not null");
            return (Criteria) this;
        }

        public Criteria andQudaoEqualTo(String value) {
            addCriterion("qudao =", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoNotEqualTo(String value) {
            addCriterion("qudao <>", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoGreaterThan(String value) {
            addCriterion("qudao >", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoGreaterThanOrEqualTo(String value) {
            addCriterion("qudao >=", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoLessThan(String value) {
            addCriterion("qudao <", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoLessThanOrEqualTo(String value) {
            addCriterion("qudao <=", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoLike(String value) {
            addCriterion("qudao like", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoNotLike(String value) {
            addCriterion("qudao not like", value, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoIn(List<String> values) {
            addCriterion("qudao in", values, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoNotIn(List<String> values) {
            addCriterion("qudao not in", values, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoBetween(String value1, String value2) {
            addCriterion("qudao between", value1, value2, "qudao");
            return (Criteria) this;
        }

        public Criteria andQudaoNotBetween(String value1, String value2) {
            addCriterion("qudao not between", value1, value2, "qudao");
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