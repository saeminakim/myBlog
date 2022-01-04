import axios from "axios";

export default {
    get: () => axios.get(`${process.env.VUE_APP_API_BASE}/feeds`)
}