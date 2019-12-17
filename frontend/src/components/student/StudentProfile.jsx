import React from 'react';
import classes from './Content.module.css'
//import Navbar from 'react-bootstrap/Navbar';

const StudentProfile = () => {
    return (
        <div className={`${classes.box} ${classes.content}`}>
            

            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <img class="w-100 rounded border" src="https://instagram.fdnk1-1.fna.fbcdn.net/vp/53a7c63e343bca3099b9f23a1cfcb8a5/5E8CABE1/t51.2885-19/s320x320/72875015_1368029390037558_6816249923525148672_n.jpg?_nc_ht=instagram.fdnk1-1.fna.fbcdn.net" />
                    </div>
                    <div class="col-md-9">
                        <div class="d-flex align-items-center">
                            <h2 class="font-weight-bold m-0">
                                Сторожук Костянтин Сергійович
                            </h2>
                            <address class="m-0 pt-2 pl-0 pl-md-4 font-weight-light text-secondary">
                                <i class="fa fa-map-marker"></i>
                                11-В
                            </address>
                        </div>
                        <p class="h5 text-primary mt-2 d-block font-weight-light">
                            Учень
                        </p>
                        <section class="mt-5">
                            <h3 class="h6 font-weight-light text-secondary text-uppercase">Середній бал</h3>
                            <div class="d-flex align-items-center">
                                <strong class="h1 font-weight-bold m-0 mr-3">10.85</strong>
                                <div>
                                    <input data-filled="fa fa-2x fa-star mr-1 text-warning" data-empty="fa fa-2x fa-star-o mr-1 text-light" value="5" type="hidden" class="rating" data-readonly />
                                </div>
                            </div>
                        </section>
                            <div class="tab-content py-4" id="myTabContent">
                                <div class="tab-pane py-3 fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <h6 class="text-uppercase font-weight-light text-secondary">
                                        Інформація
                                    </h6>
                                    <dl class="row mt-4 mb-4 pb-3">
                                        <dt class="col-sm-3">Клас</dt>
                                        <dd class="col-sm-9">11-В</dd>
                                        <dt class="col-sm-3">Дата народження</dt>
                                        <dd class="col-sm-9">20 листопада 1999</dd>
                                        
                                        
                                        <dt class="col-sm-3">Телефон</dt>
                                        <dd class="col-sm-9">+380 68-552-99-17</dd>
                                        
                                        <dt class="col-sm-3">Домашня адреса</dt>
                                        <dd class="col-sm-9">
                                            <address class="mb-0">
                                                м. Вінниця, вул. Р. Скалецького, 34а,
                                                кв.33
                                            </address>
                                        </dd>
                                        
                                        <dt class="col-sm-3">Електронна пошта</dt>
                                        <dd class="col-sm-9">
                                            <a href="mailto:kostyastorozhuk@gmail.com">kostyastorozhuk@gmail.com</a>
                                        </dd>
                                    </dl>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default StudentProfile;