// Pathify
import { make } from 'vuex-pathify'

import axios from 'axios'

import cmmnFnStore from './cmmnFnStore' //store 와 관련된 데이터를 처리하는 공통 함수 파일

// Data
const state = {
  menuList: [],
}

const mutations = {
  ...make.mutations(state),
    getMenuList(state, payload) {
      state.menuList = payload;



    }
}

const actions = {
list({
  state, // eslint-disable-line no-unused-vars
  commit, // eslint-disable-line no-unused-vars
}, dataObj) {

  const url = '/internal/davis/web/menu/list'
  axios.post(url, {

    })
    .then(res => {

      cmmnFnStore.res(res);
       commit('getMenuList', res.data.list)


    })
    .catch(err => {
      cmmnFnStore.err(err);
      //commit('axiosError', err)
    })

  },

  submit({
    state, // eslint-disable-line no-unused-vars
    commit, // eslint-disable-line no-unused-vars
  }, dataObj) {

    const url = '/internal/davis/web/menu/manage'

console.log(url)
console.log(dataObj)
    axios.post(url, dataObj)
      .then(res => {
        cmmnFnStore.res(res);
        //store.dispatch('userStore/searchBtnClick')
        console.log("=====submit ok")
      })
      .catch(err => {
        cmmnFnStore.err(err);
      })

  },
}

const getters = {}

export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters,
}