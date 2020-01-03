import React from 'react';

const TableSchedule = () => {
  return (
     <div class="bg-light box content">
            <h2 class="mb-2">Розклад уроків</h2>
            <div class="card">
                <nav class="navbar navbar-expand navbar-light bg-light">
                    <div class="mr-auto navbar-nav">
                        <a href="#"
                           class="btn btn-primary">+ Додати розклад</a>
                    </div>
                </nav>
                <nav class="navbar navbar-expand navbar-light bg-light">
                    <form class="form-inline">
                        <label class="form-label" for="validationDefault02">Виберіть клас</label>
                        <br/>
                        <select id="validationDefault02" class="custom-select w-100">
                            <option value="1">10-А</option>
                            <option value="2">11-А</option>
                            <option value="3">...</option>
                            <option value="4">9-В</option>
                        </select>
                    </form>
                </nav>
                <span class="ml-3 mt-2 mb-1 d-inline">
                        <h4>10-A</h4>
                        <small><a href="#">Змінити розклад</a></small>
                    </span>
                <div class="table-responsive">
                <table class="table ml-3">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Понеділок</th>
                        <th scope="col">Вівторок</th>
                        <th scope="col">Середа</th>
                        <th scope="col">Четверг</th>
                        <th scope="col">П'ятниця</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td></td>
                        <td>
                            <strong>Фізика</strong><br/>
                            <small>Власов О.В., к.303</small>

                        </td>
                        <td>
                            <strong>Українська мова</strong><br/>
                            <small>Дрон А.С., к.112</small>
                        </td>
                        <td>
                            <strong>Англійська мова</strong><br/>
                            <small>Гагаріна М.К., к.308</small>
                        </td>
                        <td>
                            <strong>Фізичне виховання</strong><br/>
                            <small>Михайлов С.А., к.404</small>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>
                            <strong>Українська мова</strong><br/>
                            <small>Дрон А.С., к.112</small>
                        </td>
                        <td></td>
                        <td>
                            <strong>Фізичне виховання</strong><br/>
                            <small>Михайлов С.А., к.404</small>
                        </td>
                        <td>
                            <strong>Алгебра</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td>
                            <strong>Геометрія</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">3</th>
                        <td>
                            <strong>Англійська мова</strong><br/>
                            <small>Гагаріна М.К., к.308</small>
                        </td>
                        <td>
                            <strong>Фізичне виховання</strong><br/>
                            <small>Михайлов С.А., к.404</small>
                        </td>
                        <td>
                            <strong>Алгебра</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td>
                            <strong>Геометрія</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td>
                            <strong>Фізика</strong><br/>
                            <small>Власов О.В., к.303</small>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">4</th>
                        <td>
                            <strong>Фізичне виховання</strong><br/>
                            <small>Михайлов С.А., к.404</small>
                        </td>
                        <td>
                            <strong>Алгебра</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td>
                            <strong>Геометрія</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td></td>
                        <td>
                            <strong>Українська мова</strong><br/>
                            <small>Дрон А.С., к.112</small>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">5</th>
                        <td>
                            <strong>Англійська мова</strong><br/>
                            <small>Гагаріна М.К., к.308</small>
                        </td>
                        <td></td>
                        <td>
                            <strong>Геометрія</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td>
                            <strong>Українська мова</strong><br/>
                            <small>Дрон А.С., к.112</small>
                        </td>
                        <td>
                            <strong>Англійська мова</strong><br/>
                            <small>Гагаріна М.К., к.308</small>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">6</th>
                        <td>
                            <strong>Алгебра</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td>
                            <strong>Фізичне виховання</strong><br/>
                            <small>Михайлов С.А., к.404</small>
                        </td>
                        <td>
                            <strong>Геометрія</strong><br/>
                            <small>Карлівна О.М., к.228</small>
                        </td>
                        <td>
                            <strong>Фізика</strong><br/>
                            <small>Власов О.В., к.303</small>
                        </td>
                        <td>
                            <strong>Українська мова</strong><br/>
                            <small>Дрон А.С., к.112</small>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
            </div>
        </div>

  );
}

export default TableSchedule;