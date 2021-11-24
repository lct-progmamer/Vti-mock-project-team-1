import Api from './Api';
import FormData from 'form-data';
const url = "/ctquyengoppages";
const urlcreate = "http://localhost:8080/api/v1/ctquyengops";
const getAll = (page, size) => {
    const requestParams = {
        page,
        size
    }
    return Api.get(url, { params: requestParams });
};

const create = (name, start, end, discrip,
    image1, image2, image3,
    bankName1, imageBank1, stk1,
    bankName2, imageBank2, stk2) => {

    const body = new FormData();
     
        // name:name, start:start, end:end, discrip:discrip, tongTien:tongTien,
        // image1:image1, image2:image2, image3:image3,
        // bankName1:bankName1, imageBank1:imageBank1, stk1:stk1,
        // bankName2:bankName2, imageBank2:imageBank2, stk2:stk2
        
        body.append('name', name);    
        body.append('start', start);
        body.append('end', end);  
        body.append('discrip', discrip);   
        body.append('image1', image1); 
        body.append('image2', image2);  
        body.append('image3', image3);  
        body.append('bankName1', bankName1);
        body.append('imageBank1', imageBank1);
        body.append('stk1', stk1);
        body.append('bankName2', bankName2);
        body.append('imageBank2', imageBank2);
        body.append('stk2', stk2);


    return Api.post(urlcreate, body ); 
};

// export
const api = { getAll, create }
export default api;